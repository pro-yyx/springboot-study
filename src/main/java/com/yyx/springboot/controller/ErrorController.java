package com.yyx.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/6 17:15
 */
@RestController
public class ErrorController {

    @RequestMapping(value = "/getUser")
    public  String getUser(int i){
        int j = 1 / i;
            return "success"+j;
    }
}
