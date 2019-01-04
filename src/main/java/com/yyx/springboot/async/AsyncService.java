package com.yyx.springboot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/7 18:34
 */
@Service
@Slf4j
public class AsyncService {

    private int name = 1;

    //@Async
    public String testAsync() {
        int i =0;
        /*log.info("2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("3");
        return "service返回了";*/
        /*new Thread(() -> {
            log.info("2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("3");
        }).start();*/


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
                System.out.println(name++   );
            }
        }).start();


        return "这是虚假的返回";
    }
}
