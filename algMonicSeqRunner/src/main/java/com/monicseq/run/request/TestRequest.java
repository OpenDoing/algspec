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
        params.put("format","json" );
        params.put("_t","1579601014758" );
        params.put("activity", "ttkx");
        HttpRequest httpRequest = RequestExecutor.getReqRunner("get");
        httpRequest.sendRequest("https://answer-quark.sm.cn/answer/curr",params);

//        HashMap params2 = new HashMap();
//        params2.put("id",5);
//        HttpRequest delRequest = RequestExecutor.getReqRunner("delete");
//        delRequest.sendRequest("http://localhost:8001/array/del",params2);
    }
}
