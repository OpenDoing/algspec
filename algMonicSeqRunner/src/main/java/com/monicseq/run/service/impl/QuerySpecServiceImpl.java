package com.monicseq.run.service.impl;

import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.RequestExecutor;
import com.monicseq.run.service.QuerySpecService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/25
 */
@Service
public class QuerySpecServiceImpl implements QuerySpecService {
    @Override
    public String findParmBySpec(String packname, String specName) {
//        HttpRequest requestExecutor = RequestExecutor.getReqRunner("GET");
//        HashMap hashMap = new HashMap(2);
//        hashMap.put("packageName", packname);
//        hashMap.put("specName", specName);
//        String result = requestExecutor.sendRequest("http://localhost:8090/attr", hashMap);
//
        return "";
    }
}
