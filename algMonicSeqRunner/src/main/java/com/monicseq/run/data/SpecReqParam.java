package com.monicseq.run.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.RequestExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取规约类子的相关数据
 * 服务请求参数初始化
 *
 * @author Duyining
 * @date 2019/12/25
 */
@Slf4j
@Controller
public class SpecReqParam {

    public SpecReqParam() {
    }

    /**
     * 全局变量表初始化所需要的参数
     * @param global 全局变量字符串
     * @return 单线序列处理的输入
     */
    public Map<String,Map<String,Object>> buildReq(String global,String packName) {
        Map<String,Map<String,Object>> result = new HashMap<>(16);
        // varmap  eg: greq:GetArrReq ...
        HashMap<String,String> varmap = getGlobalVarMap(global);
        for (String varname:varmap.keySet()){
            HashMap<String,Object> params = findParmBySpec(packName,varmap.get(varname));
            // 查询数据库 得到公理
            String axioms = getAxioms(packName,varmap.get(varname));
            generatorData(params,axioms);
            //从公理中读取的服务请求信息，url、method
            HashMap<String,Object> general = initReq(axioms);
            // 这里多包了一层hashmap，对服务请求参数和基本信息做了二次区分
            HashMap<String,Object> req = new HashMap<>(2);
            req.put("params", params);
            req.put("general", general);
            result.put(varname, req);
        }
        log.info("result:{}", result );
        return result;
    }

    /**
     * 服务请求的相关参数，从公理中读取
     * @param axioms 公理
     * @return 服务请求map
     */
    private HashMap<String, Object> initReq(String axioms) {
        HashMap<String, Object> req = new HashMap<>(16);
        JSONArray jsonArray = JSON.parseArray(axioms);
        for (int i = 0;i<jsonArray.size();i++){
            String lterm = jsonArray.getJSONObject(i).
                    getJSONObject("lterm").
                    getString("term");
            String rterm = jsonArray.getJSONObject(i).
                    getJSONObject("rterm").
                    getString("term");
            if (lterm.contains(".url")) {
                req.put("url", rterm);
            } else if (lterm.contains(".method")){
                req.put("method", rterm);
            }
        }
        log.info("构造的服务请求数据：{}", req);
        return req;
    }

    /**
     * 给attr生成数据
     * @param params attr
     * @param axioms
     */
    private void generatorData(HashMap<String, Object> params, String axioms) {
        for (String p:params.keySet()){
            if (constraint(p,axioms)){
                Object max = getParamInterval(p,axioms,"<");
                Object min = getParamInterval(p,axioms,">");
                params.put(p, TestDataGenerator.typeRunner(
                        params.get(p).toString().trim()).
                        getRandom(min,max));
                log.info("生成的随机数据区间值 下限值：{} 上限值：{}", min, max);
            } else {
                params.put(p, TestDataGenerator.typeRunner(
                        params.get(p).toString().trim()).
                        getRandom());

            }

        }
    }

    private Object getParamInterval(String p, String axioms, String mark) {
        JSONArray jsonArray = JSON.parseArray(axioms);
        for (int i = 0;i<jsonArray.size();i++){
            String lterm = jsonArray.getJSONObject(i).
                    getJSONObject("lterm").
                    getString("term");
            String rterm = jsonArray.getJSONObject(i).
                    getJSONObject("rterm").
                    getString("term");
            String relation = jsonArray.getJSONObject(i).
                    getString("relation");
            // > 即为下限 ,< 即为上限
            if (lterm.contains("."+p) && mark.equals(relation)){
                return rterm;
            }
        }
        return null;
    }

    /**
     * 查看公理是否对attr属性做了限制
     * @param p attr属性的键 eg：id
     * @param axioms 通过数据库查询的公理
     * @return bool
     */
    private boolean constraint(String p, String axioms) {
        JSONArray jsonArray = JSON.parseArray(axioms);
        for (int i = 0;i<jsonArray.size();i++){
            String s = jsonArray.getJSONObject(i).
                    getJSONObject("lterm").
                    getString("term");
            if (s.contains("."+p)){
                return true;
            }
        }
        return false;
    }

    /**
     * for all that全局变量表字符串转为hashmap
     * @param str 全局变量表字符串
     * @return 变量名：类子键值对
     */
    public HashMap<String,String> getGlobalVarMap(String str) {
        HashMap<String,String> var = new HashMap<>(16);
        int begin = str.indexOf("all");
        int end = str.indexOf("That");
        String temp =str.substring(begin+4,end);
        String[] req = temp.split(",");
        for (int i = 1;i< req.length;i++) {
            String[] kv = req[i].split(":");
            var.put(kv[0].trim(), kv[1].trim());
        }
        log.info("全局变量表：{}", var);
        return var;
    }

    /**
     * 通过类子名称查询Attr属性
     * @param specName 类子名
     * @return Attr属性键值对
     */
    public HashMap<String,Object> findParmBySpec(String packName,String specName){
        String result = getAttr(packName,specName);
        return JSON.parseObject(result,HashMap.class);
    }

    /**
     * string转map，fastjson.JSON工具一直报错
     * @param s string
     * @return hashmap
     */
    public static HashMap<String,Object> string2map(String s){
        HashMap<String,Object> hashMap = new HashMap<>(16);
        String mstr = s.substring(1, s.length()-1);
        String []maps = mstr.split(",");
        for (String ts:maps){
            ts = ts.trim();
            String []kv = ts.split("=");
            hashMap.put(kv[0], kv[1]);
        }
        return hashMap;
    }

    /**
     * 服务调用，查询类子的attr
     * @param packname 包名
     * @param specName 类子名
     * @return attr String
     */
    public String getAttr(String packname, String specName) {
        // TODO:方法移植到QuerySpecServiceImpl
        HttpRequest requestExecutor = RequestExecutor.getReqRunner("GET");
        HashMap<String,Object> hashMap = new HashMap<>(2);
        hashMap.put("packageName", packname);
        hashMap.put("specName", specName);
        String result = requestExecutor.sendRequest("http://localhost:8090/attr", hashMap);
        return result;
    }
    /**
     * 服务调用，查询类子的公理
     * @param packname 包名
     * @param specName 类子名
     * @return axiom String
     */
    public String getAxioms(String packname, String specName){
        // TODO:方法移植到QuerySpecServiceImpl
        HttpRequest requestExecutor = RequestExecutor.getReqRunner("GET");
        HashMap<String,Object> hashMap = new HashMap<>(2);
        hashMap.put("packageName", packname);
        hashMap.put("specName", specName);
        String result = requestExecutor.sendRequest("http://localhost:8090/axiom", hashMap);
        return result;
    }

    public static void main(String[] args) {
        SpecReqParam specReqParam = new SpecReqParam();
        //string2map("{index=Integer, id=Integer, ele=Integer}");
//        specReqParam.findParmBySpec("com.Array.req","InsertReq");
//        specReqParam.getAxioms("com.Array.req","GetArrReq");
        String test = "For all as:ArrayService,greq:GetArrReq,ireq:InsertReq,dreq:DelReq That";
        specReqParam.buildReq(test, "com.Array.req");
    }
}
