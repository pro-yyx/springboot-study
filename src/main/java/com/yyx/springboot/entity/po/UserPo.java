package com.yyx.springboot.entity.po;

import lombok.Data;

/**
 * @Description: 实体类user
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/12 14:41
 */
@Data
public class UserPo {

    private Integer id;

    private String name;

    private Integer age=25;

    public UserPo(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserPo() {
    }

    public String publicMethod(String param){
        return "这是公共方法:" + param;
    }

    private String privateMethod(String field){
        return "这是私有方法:" + field;
    }
}
