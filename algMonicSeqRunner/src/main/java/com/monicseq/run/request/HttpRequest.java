package com.monicseq.run.request;

import org.springframework.http.HttpHeaders;

import java.util.HashMap;

/**
 * HTTP服务请求接口定义
 *
 * @author Duyining
 * @date 2019/12/13
 */
public interface HttpRequest {
    /**
     * 发送HTTP请求
     * @param url 请求地址
     * @param params JSON数据
     * @return 服务响应结果
     */
    String sendRequest(String url, String params);
    /**
     * 发送HTTP请求
     * @param url 请求地址
     * @param params 键值对数据
     * @return 服务响应结果
     */
    String sendRequest(String url, HashMap params);

    /**
     * 发送HTTP请求
     * @param url 请求地址
     * @param params JSON数据
     * @param headers 请求头参数列表
     * @return 服务响应结果
     */
    String sendRequest(String url, String params, HttpHeaders headers);
    /**
     * 发送HTTP请求
     * @param url 请求地址
     * @param params 键值对请求数据
     * @param headers 请求头参数列表
     * @return 服务响应结果
     */
    String sendRequest(String url, HashMap params, HttpHeaders headers);
    String sendRequest(Request request);
}
