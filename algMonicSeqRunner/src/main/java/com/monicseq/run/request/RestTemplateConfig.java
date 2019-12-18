package com.monicseq.run.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 创建请求执行工具 RestTemplate
 *
 * @author Duyining
 * @date 2019/12/14
 */
@Configuration
public class RestTemplateConfig {

    private static RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    public static RestTemplate getRestTemplete(){
        if (restTemplate == null) {
            synchronized (RestTemplateConfig.class) {
                if (restTemplate == null) {
                    restTemplate = new RestTemplate();
                }
            }
        }
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
