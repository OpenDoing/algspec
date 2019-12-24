package com.monicseq.run.request;

import com.alibaba.fastjson.JSONObject;
import com.monicseq.run.data.TestDataGenerator;
import com.monicseq.run.data.generator.IntegerGenerator;
import com.monicseq.run.util.StringCon;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求构造器
 *
 * @author Duyining
 * @date 2019/12/14
 */
public class RequestBuilder {

    public static Request buildReq(String varname, Map<String, String> reqs, Map<String, Object> param) {
        Request request = new Request();
        String specName = reqs.get(varname.trim());
        // 查询数据库,类子的attr属性列表  eg GetArray
        HashMap<String,Object> attrs = findSpecAttr(specName.trim());
        initReqParam(varname,attrs,param);
        request.setParams(attrs);
        request.setUrl(initUrlParam(specName));
        request.setMethod(initMethodParam(specName));
        return request;
}

    /**
     * 从类子的公理中读取请求的method参数信息
     * @param specName 类子名称
     * @return method
     */
    private static String initMethodParam(String specName) {
        //TODO: 对接接口
        if ("GetArrReq".equals(specName)) {
            return "Get";
        } else if ("InsertReq".equals(specName)) {
            return "Post";
        } else if ("DelReq".equals(specName)){
            return "Post";
        }
        return "";
    }

    /**
     * 从类子的公理中读取请求的url参数信息
     * @param specName 类子名称
     * @return url
     */
    private static String initUrlParam(String specName) {
        //TODO: 对接接口
        if ("GetArrReq".equals(specName)) {
            return "http://47.100.124.249:8001/array";
        } else if ("InsertReq".equals(specName)) {
            return "http://47.100.124.249:8001/array/insert2";
        } else if ("DelReq".equals(specName)){
            return "http://47.100.124.249:8001/array/del2";
        }
        return "";
    }

    /**
     * 初始化服务请求的参数
     * @param varname 全局变量的名字
     * @param attrs 类子中的属性
     * @param param if条件中已经初始化的参数列表
     */
    private static void initReqParam(String varname,HashMap<String, Object> attrs, Map<String, Object> param) {
        // attrs 的形式为  id：Integer  index：Integer  ele：Integer
        for (String var:attrs.keySet()){
            // 查看在参数列表中是否变量已经初始化过了
            if ((param.get(varname + StringCon.DOT +  var) != null)){
                attrs.put(var, param.get(varname + StringCon.DOT +  var));
            } else {
                // 调用数据生成模块，随机生成参数
                if (StringCon.INTERGER.equals(attrs.get(var))){
                    attrs.put(var, IntegerGenerator.getRandomInt(1, 10));
                }
            }
        }
    }

    /**
     * 查询类子的attr属性
     * @param specName 类子名称
     * @return attr
     */
    private static HashMap<String,Object> findSpecAttr(String specName) {
        //TODO: 对接接口
        HashMap<String,Object> param = new HashMap<>(16);
        if ("GetArrReq".equals(specName)){
            param.put("id", "Integer");
        } else if ("InsertReq".equals(specName)) {
            param.put("id", "Integer");
            param.put("index", "Integer");
            param.put("ele", "Integer");
        } else if ("DelReq".equals(specName)) {
            param.put("id", "Integer");
            param.put("index", "Integer");
        }
        return param;
    }

    private static String getSortName(String s,Map<String, String> reqs) {
        if (reqs==null){
            return "";
        }
        return reqs.get(s);
    }

    public static void main(String[] args) {
        String json = "";
        Map<String,Object> map = new HashMap<>(16);
        map.put("id", 1);
        map.put("index", 2);
        map.put("ele", 43);
        Map<String,Object> map1 = new HashMap();
        map1.put("id", 5);
        map1.put("name", "Tom Smith");
        map.put("patient", map1);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
    }
}
