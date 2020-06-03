package com.doing.array.dao;

import com.doing.array.entity.Array;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/5
 */
public interface ArrayRepo extends JpaRepository<Array,Integer>{
    /**
     * 通过array id查询数组
     * @param id id
     * @return id标识的数组
     */
    Array findArrayById(Integer id);


}
