package com.yyx.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/6 14:30
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){
        String resilt = "this is 2222";
        return resilt;
    }

   @GetMapping("/test")
    public String test(){
        return "hhahha";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2";
    }


    public static void main(String[] args) {

        System.out.println("123456789101".replace("(\\d{4})\\[0-9]* (\\w{4})","$1*****$2"));
    }
}
