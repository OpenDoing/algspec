package com.monicseq.run.request.method;

import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.RestTemplateConfig;
import com.monicseq.run.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/13
 */
@Slf4j
public class DeleteRequest implements HttpRequest {

    @Override
    public String sendRequest(String url, String params) {
        return null;
    }

    @Override
    public String sendRequest(String url, HashMap params) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        String contact = RequestUtil.contructPutPath(params);
        RestTemplateConfig.getRestTemplete().delete(url + contact,String.class);
        log.info("请求地址：{} 请求方法：{} 请求参数：{} 响应结果：{}",url+contact , "Delete",params,"success");
        return "success";
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
