package com.monicseq.run.request;

import java.util.HashMap;
import java.util.Map;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/14
 */
public class TestRequest {

    public static void main(String[] args) {
        //"http://localhost:8001/array/ele?id={id}&index={index}"
        HashMap params = new HashMap();
        params.put("id",1 );
        params.put("index",2 );
        params.put("ele", 43);
        HttpRequest httpRequest = RequestExecutor.getReqRunner("put");
        httpRequest.sendRequest("http://localhost:8001/array/modify",params);

        HashMap params2 = new HashMap();
        params2.put("id",5);
        HttpRequest delRequest = RequestExecutor.getReqRunner("delete");
        delRequest.sendRequest("http://localhost:8001/array/del",params2);
    }
}
