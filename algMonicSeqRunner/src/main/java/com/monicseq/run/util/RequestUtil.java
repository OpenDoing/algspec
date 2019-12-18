package com.monicseq.run.util;

import java.util.HashMap;

/**
 * 请求工具类
 *
 * @author Duyining
 * @date 2019/12/14
 */
public class RequestUtil {

    /**
     * 构造请求的路径，适用于GETforObject
     * @param params 参数列表
     * @return 路径
     */
    public static String contructPath(HashMap params){
        StringBuilder contact = new StringBuilder("?");
        // 设计临时变量，保证&符号的拼接正确
        int i = 1;
        for (Object s : params.keySet()) {
            StringBuilder param = new StringBuilder(s.toString());
            if (i==params.size()){
                contact.append(param).append("={").append(param).append("}");
            } else {
                i++;
                contact.append(param).append("={").append(param).append("}&");
            }
        }
        return contact.toString();
    }

    /**
     * 构造请求的路径，适用于put、delete方法
     * @param params 参数列表
     * @return 路径
     */
    public static String contructPutPath(HashMap params){
        StringBuilder contact = new StringBuilder("?");
        // 设计临时变量，保证&符号的拼接正确
        int i = 1;
        for (Object s : params.keySet()) {
            StringBuilder param = new StringBuilder(s.toString());
            if (i==params.size()){
                contact.append(param).append("=").append(params.get(s));
            } else {
                i++;
                contact.append(param).append("=").append(params.get(s)).append("&");
            }
        }
        return contact.toString();
    }


}
