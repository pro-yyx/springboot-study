package com.yyx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyx.springboot.entity.po.UserPo;
import com.yyx.springboot.mapper.test.UserMapper;
import com.yyx.springboot.mapper01.UserMapper01;
import com.yyx.springboot.mapper02.UserMapper02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/11/12 15:51
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapper01 userMapper01;
   /* @Autowired
    private UserMapper02 userMapper02;
*/

    public int insert(UserPo userPo){

         return  userMapper.insert(userPo.getName(),userPo.getAge());
    }

    public UserPo findByName(String name){
       return userMapper.findByName(name);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert2(String name,Integer age,Integer num) {
        userMapper01.insert(name, age);
       /* int i = 10 / num;
        userMapper02.insert(name, age);*/
    }

    public PageInfo<UserPo> findAllUsers(Integer pageNum, Integer pageSize) {
        //mysql分页查询使用limit  oracle 使用伪列   sqlserver 使用top     limit 1，2  查询第一页，查询两条记录
        //底层原理  改写sql
        PageHelper.startPage(pageNum, pageSize);
        List<UserPo> allUsers = userMapper01.findAllUsers(pageNum, pageSize);
        //返回给客户端展示。
        PageInfo<UserPo> userPoPageInfo = new PageInfo<>(allUsers);
        return userPoPageInfo;

    }
}
