package com.monicseq.run.request;

import com.alibaba.fastjson.JSONObject;
import com.monicseq.run.request.method.DeleteRequest;
import com.monicseq.run.request.method.GetRequest;
import com.monicseq.run.request.method.PostRequest;
import com.monicseq.run.request.method.PutRequest;
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
import java.util.Map;

/**
 * 请求执行器
 *
 * @author Duyining
 * @date 2019/12/11
 */
@Slf4j
public class RequestExecutor {

    @Autowired
    private static RestTemplate restTemplate;

    private static String GET = "Get";
    private static String POST = "Post";
    private static String PUT = "Put";
    private static String DELETE = "Delete";

    public static HttpRequest getReqRunner(String method){
        if (GET.equalsIgnoreCase(method)){
            return new GetRequest();
        } else if (POST.equalsIgnoreCase(method)) {
            return new PostRequest();
        } else if (PUT.equalsIgnoreCase(method)) {
            return new PutRequest();
        } else if (DELETE.equalsIgnoreCase(method)) {
            return new DeleteRequest();
        }
        return null;
    }

    public static String invoke(String url, HashMap params) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSONObject.toJSONString(params), headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        return stringResponseEntity.getBody();
    }




    public static String test() throws Exception {
        String url = "http://localhost:8001/array/insert2";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("id", 1);
        requestParam.put("index", 1);
        requestParam.put("ele", 18);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity(requestParam, headers);
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        String s = stringResponseEntity.getBody();
        log.info(s);
        return s;
    }

    public static void main(String[] args) throws Exception {



//        HashMap map = new HashMap<>(16);
//        map.put("id",1 );
//        map.put("index",1 );
//        map.put("ele",11);
//        try{
//            String result = invoke("http://localhost:8001/array/insert", map);
//            log.info("服务调用相应结果：{}",result);
//        } catch (Exception e){
//            log.error("服务调用失败");
//        }
        String s = "{\n" +
                "  \"id\":1,\n" +
                "  \"index\":1, \n" +
                "  \"ele\":19\n" +
                "}";


        test();

    }
}
