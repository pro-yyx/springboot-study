package com.yyx.springboot;

import com.yyx.springboot.jtaatomikos.DataConfig01;
import com.yyx.springboot.jtaatomikos.DataConfig02;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description:
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/6 14:33
 */
@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties({DataConfig01.class,DataConfig02.class})
@MapperScan(basePackages = "com.yyx.springboot.mapper.test")
@EnableAdminServer
public class AppStarter {

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }
}
