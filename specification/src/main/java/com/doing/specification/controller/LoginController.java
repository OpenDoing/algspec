package com.doing.specification.controller;

import com.doing.specification.entity.User;
import com.doing.specification.mapper.LoginRepo;
import com.doing.specification.util.CharUtil;
import com.doing.specification.util.JacksonUtil;
import com.doing.specification.util.ResponseUtil;
import com.doing.specification.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginRepo loginRepo;

    @PostMapping("/login")
    public Object login(@RequestBody String body){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.badArgument();
        }
        User user = loginRepo.findUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, user.getPassword())){
            return ResponseUtil.fail(403, "账号密码不对");
        }
        User newUser = updateToken(user);
        loginRepo.save(newUser);
        newUser.setPassword(null);
        return ResponseUtil.ok(newUser);
    }

    @PostMapping("/register")
    public Object reg(@RequestParam String username,
                      @RequestParam String password){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.badArgument();
        }

        User user = loginRepo.findUserByUsername(username);
        if(user != null){
            return ResponseUtil.regerr();
        }
        User newUser = new User();
        newUser.setUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(password));
        User reg = updateToken(newUser);
        newUser.setToken(reg.getToken());
        newUser.setUpdatetime(reg.getUpdatetime());
        newUser.setExpiretime(reg.getExpiretime());
        loginRepo.save(newUser);
        return ResponseUtil.ok();
    }

    //更新token
    private User updateToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        //token过期  刷新token
        if(user.getExpiretime() == null || user.getExpiretime().isBefore(now) || user.getToken() == null){
            LocalDateTime expire = now.plusMinutes(60);
            user.setUpdatetime(now);
            user.setExpiretime(expire);
            String tokenNew = CharUtil.getRandomString(32);
            user.setToken(tokenNew);
        }
        return user;
    }
}
