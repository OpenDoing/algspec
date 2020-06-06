package edu.njust.hjj.asts.serviceImpl;

import edu.njust.hjj.asts.dao.TermMapper;
import edu.njust.hjj.asts.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermServiceImpl implements TermService{

    @Autowired
    TermMapper termMapper;

    @Override
    public String findIterm(String term) {
        if(termMapper.seleteITerm(term) == null){
            System.out.println("项不存在逆项");
        }
        return termMapper.seleteITerm(term);
    }

    @Override
    public List<String> findAllTerm() {
        return termMapper.selectAllTerm();
    }
}
