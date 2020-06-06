package com.doing.parse.controller;

import com.doing.parse.asParse.main;
import com.doing.parse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ParseController {

    @Value("${filepath}")
    private String filePath;

    @GetMapping("/parse")
    public Object parse(@RequestParam String username, @RequestParam String path){
        main ma = new main();
        String pm;
        pm = ma.specParser(path,username);
        System.out.println("parseResult:" + pm);
        return ResponseUtil.ok(pm);
    }

}
