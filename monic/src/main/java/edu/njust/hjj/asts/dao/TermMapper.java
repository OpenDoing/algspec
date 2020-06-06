package edu.njust.hjj.asts.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TermMapper {
    String seleteITerm(String term);

    List<String> selectAllTerm();
}
