package com.monicseq.run.request;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务请求格式
 *
 * @author Duyining
 * @date 2019/12/11
 */

public class Request {
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求参数，为JSON类型，针对复杂类型
     */
    private JSONObject jsonp;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求参数，为基本数据类型
     */
    private HashMap<String,Object> params;
    /**
     * 请求头参数
     */
    private HttpHeaders headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getJsonp() {
        return jsonp;
    }

    public void setJsonp(JSONObject jsonp) {
        this.jsonp = jsonp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }
}
