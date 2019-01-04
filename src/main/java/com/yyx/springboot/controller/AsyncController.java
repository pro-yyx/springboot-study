package com.yyx.springboot.controller;

import com.yyx.springboot.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/7 18:33
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value = "/testAsync")
    public String testAsync() throws InterruptedException {
        log.info("1");

        System.out.println(asyncService.testAsync());

        log.info("4");
        return "end";
    }
}
