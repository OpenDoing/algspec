package com.monicseq.run.service;

import org.springframework.stereotype.Service;

/**
 * 调用数据库的接口
 *
 * @author Duyining
 * @date 2019/12/14
 */
public interface QuerySpecService {

    /**
     * 查询某包下某类子的attr
     * @param packname 包名
     * @param specName 类子名
     * @return attr
     */
    String findParmBySpec(String packname,String specName);
}
