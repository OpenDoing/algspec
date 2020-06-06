package com.doing.specification.mapper;

import com.doing.specification.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecRepo extends JpaRepository<Specification,String> {
    List<Specification> findAllByUsernameAndSpecid(String username, String SpecID);

    Specification findByUsernameAndSpecidAndSubSpec(String username, String SpecID, String subSpec);
}
