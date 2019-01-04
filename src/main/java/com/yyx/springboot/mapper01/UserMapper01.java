package com.yyx.springboot.mapper01;

import com.yyx.springboot.entity.po.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: user mapper
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/12 15:47
 */
public interface UserMapper01 {

    @Select("select * from user where name=#{name}")
    UserPo findByName(@Param("name") String name);

    @Insert("insert into user(name,age) values (#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Select("select * from user")
    List<UserPo> findAllUsers(Integer pageNum,Integer pageSize);
}