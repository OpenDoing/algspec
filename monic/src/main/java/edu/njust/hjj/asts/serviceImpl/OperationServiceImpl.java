package edu.njust.hjj.asts.serviceImpl;


import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.bean.OperationBean;
import edu.njust.hjj.asts.dao.OperationMapper;
import edu.njust.hjj.asts.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    private OperationMapper operationMapper;

//    @Override
//    public List<Operation> getStackOpts() {
//        operations = new ArrayList<Operation>();
//        for (OperationBean operationBean:operationMapper.selectAllOpt()) {
//            Operation operation = new Operation();
//            operation.setName(operationBean.getName());
//            if(operationBean.getArgDT() == null){
//                operation.setArgDT(null);
//            }else{
//                operation.setArgDT(Arrays.asList(operationBean.getArgDT().split(",")));
//            }
//            if(operationBean.getRetDT() == null){
//                operation.setRetDT(null);
//            }else{
//                operation.setRetDT(Arrays.asList(operationBean.getRetDT().split(",")));
//            }
//            operation.setOptType(operationBean.getOptType());
//            operation.setOptBelong(operationBean.getOptBelong());
//            operations.add(operation);
//        }
//        return operations;
//    }


    /**
     * 获取操作信息
     * @param name 操作名
     * @return 操作信息
     */
    @Override
    public Operation getOpt(String name){
        OperationBean optBean = operationMapper.selectOpt(name);  //若操作名相同，数据库可能会查询到多个结果，程序异常崩溃

        if(optBean == null) return null;

        Operation opt = new Operation();
        opt.setName(optBean.getName());
        if(optBean.getArgDT() == null){
            opt.setArgDT(null);
        }else{
            opt.setArgDT(Arrays.asList(optBean.getArgDT().split(",")));
        }
        if(optBean.getRetDT() == null){
            opt.setRetDT(null);
        }else{
            opt.setRetDT(Arrays.asList(optBean.getRetDT().split(",")));
        }
        opt.setOptType(optBean.getOptType());
        opt.setOptBelong(optBean.getOptBelong());
     //   System.out.println(opt);
        return opt;
    }

    /**
     * 获取操作返回的第一个类型
     * @param name 操作名
     * @return 操作返回的第一个类型
     */
    @Override
    public String getFirstRtType(String name) {
        String retTypesStr = operationMapper.selectRet(name);

        if(retTypesStr == null) {
            return null;
        }
        else {
            return retTypesStr.split(",")[0];

        }
    }
}
