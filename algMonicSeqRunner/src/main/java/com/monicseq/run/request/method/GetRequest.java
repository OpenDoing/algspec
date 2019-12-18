package com.monicseq.run.request.method;

import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.RestTemplateConfig;
import com.monicseq.run.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/13
 */
@Slf4j
public class GetRequest implements HttpRequest {

    @Override
    public String sendRequest(String url, String params) {
        return null;
    }

    @Override
    public String sendRequest(String url, HashMap params) {
        String contact = RequestUtil.contructPath(params);
        ResponseEntity<String> responseEntity = RestTemplateConfig.getRestTemplete().getForEntity(url+ contact, String.class, params);
        log.info("请求地址：{} 请求方法：{} 请求参数：{}",url , "Get",params);
        log.info("请求响应结果：{}",responseEntity.getBody());
        return responseEntity.getBody();
    }

    @Override
    public String sendRequest(String url, String params, HttpHeaders headers) {
        return null;
    }

    @Override
    public String sendRequest(String url, HashMap params, HttpHeaders headers) {
        return null;
    }
}
