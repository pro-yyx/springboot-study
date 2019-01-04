package com.yyx.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.yyx.springboot.entity.po.UserPo;
import com.yyx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/12 16:27
 */
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public int insertUser(@RequestBody UserPo userPo) {
      return   userService.insert(userPo);
    }

    @RequestMapping("/findByName")
    public UserPo findByName(String name) {
        return  userService.findByName(name);
    }

    @RequestMapping("/insert")
    public void findByName(String name,Integer age,Integer num) {
          userService.insert2(name,age,num);
    }

    @RequestMapping("/findAllUsers")
    public PageInfo<UserPo> findAllUsers(Integer pageNum, Integer pageSize) {
        PageInfo<UserPo> allUsers = userService.findAllUsers(pageNum, pageSize);
        return allUsers;
    }

}
