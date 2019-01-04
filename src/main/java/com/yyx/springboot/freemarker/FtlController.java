package com.yyx.springboot.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Description:
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/6 16:57
 */
@Controller
public class FtlController {

    @RequestMapping(value = "/testFtl")
    public String testFtl(Map<String,Object> map){
        map.put("name", "尹玉新");
        map.put("age",25);
        map.put("sex","1");
        return "ftl";
    }
}
