package com.doing.specification.service.Imp;

import com.doing.specification.mapper.SpecAndURepo;
import com.doing.specification.service.SaveSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaveSpecImpl implements SaveSpec {
    @Autowired
    private SpecAndURepo specAndURepo;
    @Override
    public int insert(String service, String username) {
        specAndURepo.insert(service, username);
        return 0;
    }
}
