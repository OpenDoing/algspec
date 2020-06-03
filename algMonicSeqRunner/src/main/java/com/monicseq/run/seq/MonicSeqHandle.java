package com.monicseq.run.seq;

import com.doing.compare.Comparator;
import com.doing.compare.CompareType;
import com.doing.compare.adapter.CompareAdapter;
import com.monicseq.run.data.SpecReqParam;
import com.monicseq.run.data.TestDataGenerator;
import com.monicseq.run.data.generator.IntegerGenerator;
import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.Request;
import com.monicseq.run.request.RequestBuilder;
import com.monicseq.run.request.RequestExecutor;
import com.monicseq.run.request.method.GetRequest;
import com.monicseq.run.strategy.intercept.MyInterceptor;
import com.monicseq.run.strategy.proxy.ProxyBean;
import com.monicseq.run.util.FileUtil;
import com.monicseq.run.util.Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 单线测试序列处理
 *
 * @author Duyining
 * @date 2019/12/5
 */
@Slf4j
public class MonicSeqHandle {
    /**
     * 单线测试序列的结果
     */
    public static Map<String,Object> result = new HashMap<>(16);

    public static String ISEQUAL = "isEq";
    public static String ISSUBSET = "isSub";
    public static String ISSAME = "isSame";
    public static String EMPTY = "";
    public static String DOT = ".";
    public static String LINE = "_";
    public static String INTERGER = "Integer";
    public static String ASSERT = "Assert";
    public static String IS = "is";
    public static String EQUAL = "=";
    public static String TRUE = "true";

    /**
     * 测试数据生成器读取类子生成的数据集
     */
    public static Map<String,Map<String,Object>> tdata = new HashMap<>(16);


    /**
     * 序列中用到的所有参数
     */
    public static Map<String,Object> param = new HashMap<>(16);

    /**
     * 全局变量表
     * TODO:删除全局变量表的方案，采取测试数据生成器生成的数据集
     */
    @Deprecated
    public static Map<String,String> reqs = new HashMap<>(16);

    public static void initGlobal(String s) {
        reqs = Util.getGlobalVar(s);
    }

    /**
     * 从文件中读取单线测试序列
     * @param file 文件路径
     * @throws IOException IO异常
     */
    public static void getSeq(String file) throws IOException{
        String monicSequence = FileUtil.readFile(file);
        parseSeq(monicSequence);
    }

    public static void parseSeq(String mseq) {
        String[] seq = mseq.split("\n");
        for (int i = 0;i<seq.length;i++) {
            if (!EMPTY.equals(seq[i])){
                if (!handleSingleSeq(seq[i].trim())) {
                    log.error("断言为假，无法继续执行");
                    break;
                }
            }
        }
    }

    private static boolean handleSingleSeq(String s) {
        if(s.startsWith(ASSERT)) {
            boolean b = handleAssert(s);
            if (b) {
                log.info("{} 结果为：{}", "AssertTrue", true);
            } else {
                log.info("{} 结果为：{}", "AssertTrue", false);
            }
            return b;
        }
        String[] ope = s.split(EQUAL);
        if (ope[1].trim().startsWith(IS)) {
            boolean cres = handleCompare(ope[1]);
            result.put(ope[0].trim(),cres);
            log.info("{} 结果为：{}",ope[0],result.get(ope[0].trim()));
        } else {
            String response = handleServiceReq(s,reqs,param);
            result.put(ope[0].trim(), response);
            log.info("{} 结果为：{}",ope[0],result.get(ope[0].trim()));
        }
        return true;
    }

    /**
     * 处理服务请求操作
     * @param s 单线序列操作  getArray(greq)
     * @param reqs 全局变量的map，通过greq查询对应的类子结构 GetArrayReq
     * @param param 变量初始化map，已经初始化的map不应该被重复初始化
     */
    private static String handleServiceReq(String s, Map<String, String> reqs, Map<String, Object> param) {
        // getArray(greq)
        int left = s.indexOf("(");
        int right = s.indexOf(")");
        String ps = s.substring(left+1,right);
        Request request = RequestBuilder.buildReq(ps,tdata);
        String url = request.getUrl();
        HttpRequest helloService = RequestExecutor.getReqRunner(request.getMethod());
//        HttpRequest proxy = (HttpRequest) ProxyBean.getProxyBean(helloService, MyInterceptor.getInstance());
////        String proRes = proxy.sendRequest(url, request.getParams());
////        String res = handleProxyResult(proRes,request,proxy);
        String res = helloService.sendRequest(url, request.getParams());
        return res;
    }

    private static String handleProxyResult(String res, Request request, HttpRequest proxy) {
        if ("RETRY".equals(res)){
            return proxy.sendRequest(request.getUrl(), request.getParams());
        }else if ("RETRY".equals(res)){

        }
        return res;
    }

    private static boolean handleAssert(String s) {
        int left = s.indexOf("(");
        int right = s.indexOf(")");
        String ps = s.substring(left+1,right);
        log.info("操作：{}  参数: {}","AssertTrue",ps);
        String temp = result.get(ps).toString();
        return TRUE.equals(temp);
    }

    private static boolean handleCompare(String s) {
        int left = s.indexOf("(");
        int right = s.indexOf(")");
        String type = s.substring(0,left).trim();
        String ps = s.substring(left+1,right);
        String[] params = ps.split(",");
        log.info("操作: {}   参数1: {}   参数2: {}" , type,params[0],params[1]);
        if (ISEQUAL.equals(type)) {
            return handleIsEqual(params[0],params[1]);
        } else if(ISSUBSET.equals(type)) {
            return handleIsSubset(params[0],params[1]);
        } else if (ISSAME.equals(type)) {

        } else {
            // ......
        }
        return true;
    }

    private static boolean handleIsSubset(String param, String param1) {
        return true;
    }

    private static boolean handleIsEqual(String param1, String param2) {
        // 两个都是服务请求参数
        if (param1.contains(DOT) && param2.contains(DOT)) {
            // 参数列表中没有这两个参数，需要将参数放进来
            if (!param.containsKey(param1) && !param.containsKey(param2)) {
                String vname1 = param1.substring(0,param1.indexOf(DOT));
                String vparam1 = param1.substring(param1.indexOf(DOT)+1);
                // 获取测试数据生成器中的数据
                HashMap param3 = (HashMap)tdata.get(vname1).get("params");
                param.put(param1, param3.get(vparam1));
                param.put(param2, param3.get(vparam1));
                return true;
            } else if (param.containsKey(param1) || param.containsKey(param2)) {
                // 如果其中一个参数已经初始化，则将初始化的值赋给未初始化的参数
                if (param.containsKey(param1)) {
                    param.put(param2,param.get(param1));
                } else {
                    param.put(param1,param.get(param2));
                }
                return true;
            }
        } else if (param1.startsWith(LINE) && !param2.startsWith(LINE)) {
            /* 如果类似这种形式 isEq(_1,true) */
            String pa1 = result.get(param1).toString();
            return pa1.equals(param2);
        } else if (param1.startsWith(LINE) && param2.startsWith(LINE)) {
            // 如果类似这种形式 isEq(_7,_10)
            String pa1 = result.get(param1).toString();
            String pa2 = result.get(param2).toString();
//            Comparator comparator = new CompareAdapter();
//            return comparator.compare(pa1, pa2, CompareType.EQUAL).isFlag();
            return pa1.equals(pa2);
        }
        return false;
    }

    private static String getParamType(String param1) {
        //1
        return "Integer";
    }

    /**
     * 展示参数变量列表的键值对
     */
    public static void getPrams(){
        Iterator iterator = param.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            log.info("参数:{} 参数的值：{}", key, value);
        }
    }

    public static void main(String[] args) throws IOException{
        SpecReqParam specReqParam = new SpecReqParam();
        String test = "For all as:ArrayService,greq:GetArrReq,ireq:InsertReq,dreq:DelReq That";
        MonicSeqHandle.tdata = specReqParam.buildReq(test, "com.Array.req");

//        initGlobal("For all as:ArrayService,greq:GetArrReq,ireq:InsertReq,dreq:DelReq That");
        // 序列执行起点
        getSeq("D:\\1NJUST\\大论文\\paper\\casestudy\\monicArray.txt");
        getPrams();

    }

}
