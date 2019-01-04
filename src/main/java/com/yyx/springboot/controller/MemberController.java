package com.yyx.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 这是springboot学习的第一个案列
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/6 14:28
 */
@RestController
@RequestMapping(value = "/test")
public class MemberController {

    @RequestMapping(value = "/member")
    public String member(String name,Integer age,Boolean sex){
        return "this is member()";
    }




}
