package com.doing.specification.mapper;

import com.doing.specification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo  extends JpaRepository<User, String> {
    User findUserByUsername(String username);

//    @Transactional
//    @Modifying
//    @Query("INSERT INTO user(username, password, token, update, expire) VALUES ()", nativeQuery = true)
//    int insert()
}
