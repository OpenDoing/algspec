package edu.njust.hjj.asts.controller;

import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    @Autowired
    OperationService operationService;
//
//    @RequestMapping("/print")
//    public void print(){
//        for (Operation opt : operationService.getStackOpts()) {
//            opt.testPrint();
//        }
//    }

    @RequestMapping("/getOpt")
    public void getOpt(String name){
        operationService.getOpt(name);
    }

    @RequestMapping("/getFirstRtType")
    public String getFirstRtType(String name){
        return operationService.getFirstRtType(name);
    }
}
