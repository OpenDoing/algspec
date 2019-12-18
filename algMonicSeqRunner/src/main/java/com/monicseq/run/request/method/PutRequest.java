package com.monicseq.run.request.method;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.RestTemplateConfig;
import com.monicseq.run.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/13
 */
@Slf4j
public class PutRequest implements HttpRequest {


    @Override
    public String sendRequest(String url, String params) {
        return null;
    }

    @Override
    public String sendRequest(String url, HashMap params) {
        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON);
        String contact = RequestUtil.contructPutPath(params);
        log.info("请求地址：{} 请求方法：{} 请求参数：{} 响应结果：{}",url+contact , "Put",params,"success");
        RestTemplateConfig.getRestTemplete().put(url + contact,String.class);

        return "success";
    }

    @Override
    public String sendRequest(String url, String params, HttpHeaders headers) {
        return null;
    }

    @Override
    public String sendRequest(String url, HashMap params, HttpHeaders headers) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String value = mapper.writeValueAsString(params);
            HttpEntity<String> entity = new HttpEntity<String>(value,headers);
            RestTemplateConfig.getRestTemplete().put(url, entity);
            log.info("请求地址：{} 请求方法：{} 请求参数：{}",url , "Put",params);
        } catch (JsonProcessingException j) {
            log.error("JSONProcessing  解析错误");
        }
        return "success";
    }
}
