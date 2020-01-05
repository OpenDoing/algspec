package com.monicseq.run.util;

import java.util.HashMap;
import java.util.Map;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/9
 */
public class Util {



    /**
     * 服务请求的格式定义
     * @param str 这里作为例子，输入的是全局变量
     * @return 全局变量中服务请求的格式
     */
    public static Map<String,Map<String,Object>> getReqFomat(String str) {
        Map<String,Map<String,Object>> reqformat = new HashMap<>();
        int begin = str.indexOf("all");
        int end = str.indexOf("That");
        String temp =str.substring(begin+4,end);
        String[] req = temp.split(",");
        for (String s :req){
            System.out.println(s);
        }
        for (int i = 1;i< req.length;i++) {
            String[] kv = req[i].split(":");
            HashMap<String,Object> request = new HashMap<>();
            //request = findParmBySpec(kv[1]);
            request.putAll((findReqBySpec(kv[1])));
            reqformat.put(kv[0], request);
        }
        System.out.println(req.length);
        return reqformat;
    }

    public static Map<String,String> getGlobalVar(String str) {
        Map<String,String> reqformat = new HashMap<>();
        int begin = str.indexOf("all");
        int end = str.indexOf("That");
        String temp =str.substring(begin+4,end);
        String[] req = temp.split(",");
        for (int i = 1;i< req.length;i++) {
            String[] kv = req[i].split(":");
            reqformat.put(kv[0].trim(), kv[1].trim());
        }
        return reqformat;
    }



    /**
     * 通过类子名称查询在公理中声明的服务接口信息
     * @param specName 类子名称
     * @return 服务接口信息键值对
     */
    public static HashMap<String,Object> findReqBySpec(String specName){
        HashMap<String,Object> req = new HashMap<>();
        if ("GetArrReq".equals(specName)){
            req.put("url","https://localhost:8001/array");
            req.put("method","Get");
        } else if ("InsertReq".equals(specName)) {
            req.put("url","https://localhost:8001/array/insert");
            req.put("method","Post");
        }else if ("DelReq".equals(specName)) {
            req.put("url","https://localhost:8001/array/del2");
            req.put("method","Post");
        }
        return req;
    }



    public static void main(String[] args) {
        getReqFomat("For all as:PatientInfoService,areq2:AddPatientRequest,ereq:EditPatient,ireq:ByIdRequest That");
    }
}
