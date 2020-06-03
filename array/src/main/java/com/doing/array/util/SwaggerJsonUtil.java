//package com.doing.array.util;
//
//import com.medical.patientinfo.entity.SwaggerJsonEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
///**
// * @author duwen@shein.com
// * @date 2019/3/6 16:50
// */
//public class SwaggerJsonUtil {
//    private final static String URL = "http://localhost:8001/v2/api-docs";
//
//    private static Map<String, SwaggerJsonEntity.Definition> definitions;
//
//    private static Map<String, Map<String, SwaggerJsonEntity.RequestEntity>> paths;
//
//    public static void getJson() {
//        RestTemplate restTemplate = new RestTemplate();
//        SwaggerJsonEntity swaggerJsonEntity = restTemplate.getForObject(URL, SwaggerJsonEntity.class);
//        definitions = swaggerJsonEntity.getDefinitions();
//        paths = swaggerJsonEntity.getPaths();
//    }
//
//    public void send(String path, String method) {
//        SwaggerJsonEntity.RequestEntity requestEntity = paths.get(path).get(method);
//        if (requestEntity.getParameters().length != 0){
//            for (SwaggerJsonEntity.Parameter parameter:requestEntity.getParameters()) {
//                  if (parameter.getType() != null){
//
//                  }
//            }
//        }
//    }
//}
