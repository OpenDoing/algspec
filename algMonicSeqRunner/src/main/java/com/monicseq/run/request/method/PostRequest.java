package com.monicseq.run.request.method;

import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/13
 */
@Slf4j
public class PostRequest implements HttpRequest {

    /**
     * POST 方法发送请求，默认采用这个
     * @param url 请求地址
     * @param params JSON 请求参数
     * @return 服务响应的结果
     * @throws Exception 服务调用异常
     */
    @Override
    public String sendRequest(String url, String params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity(params, headers);
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        return stringResponseEntity.getBody();
    }

    @Override
    public String sendRequest(String url, HashMap params) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity(params, header);
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("请求地址：{} 请求方法：{} 请求参数：{}",url , "Post",params);
        log.info("请求响应结果：{}",stringResponseEntity.getBody());
        return stringResponseEntity.getBody();
    }

    /**
     * POST 方法发送请求，可设置Header
     * @param url 请求地址
     * @param params JSON 请求参数
     * @return 服务响应的结果
     * @throws Exception 服务调用异常
     */
    @Override
    public String sendRequest(String url, String params, HttpHeaders headers){
        HttpEntity<String> httpEntity = new HttpEntity(params, headers);
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("请求地址：{} 请求方法：{} 请求参数：{}",url , "Post",params);
        log.info("请求响应结果：{}",stringResponseEntity.getBody());
        return stringResponseEntity.getBody();
    }

    @Override
    public String sendRequest(String url, HashMap params, HttpHeaders headers) {
        return null;
    }

    @Override
    public String sendRequest(Request request) {
        return null;
    }


}
