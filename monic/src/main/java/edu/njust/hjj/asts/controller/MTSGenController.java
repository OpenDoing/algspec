package edu.njust.hjj.asts.controller;

import edu.njust.hjj.asts.service.MTSGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MTSGenController {
    @Autowired
    MTSGenService mtsGenService;

    @RequestMapping("/getMTS")
    @ResponseBody
    public void getMTS() {

    }
}
