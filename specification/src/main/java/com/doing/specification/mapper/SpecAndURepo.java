package com.doing.specification.mapper;

import com.doing.specification.entity.SpecAndUsername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecAndURepo extends JpaRepository<SpecAndUsername,String> {

    @Modifying
    @Query(value = "INSERT INTO spec(SpecID,username) VALUES (?1, ?2)",nativeQuery = true)
    int insert(String service, String username);

    List<SpecAndUsername> findAllByUsername(String username);

    SpecAndUsername findAllByUsernameAndSpecid(String username, String specid);
}
