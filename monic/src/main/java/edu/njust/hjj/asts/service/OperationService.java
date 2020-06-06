package edu.njust.hjj.asts.service;

import edu.njust.hjj.asts.bean.Operation;

import java.util.List;

public interface OperationService {
//    List<Operation> getStackOpts();
    Operation getOpt(String name);      //获取操作

    String getFirstRtType(String name); //获取操作的第一个返回类型
}
