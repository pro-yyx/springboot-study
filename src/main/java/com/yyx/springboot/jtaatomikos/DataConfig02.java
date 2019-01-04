package com.yyx.springboot.jtaatomikos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/21 13:54
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.data02")
public class DataConfig02 {

    private String url;

    private String username;

    private String password;

    private int minPoolSize;

    private int maxPoolSize;

    private int maxLiftTime;

    private int borrowConnectionTimeout;

    private int loginTimeout;

    private int maintenanceInterval;

    private int maxIdleTime;

    private String testQuery;
}
