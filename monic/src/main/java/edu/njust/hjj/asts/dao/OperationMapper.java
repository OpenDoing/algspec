package edu.njust.hjj.asts.dao;

import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.bean.OperationBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationMapper {
    List<OperationBean> selectAllOpt();

    OperationBean selectOpt(String name);

    String selectRet(String name);
}
