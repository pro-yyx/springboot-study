package com.yyx.springboot.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 全局捕获异常
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/11/6 18:03
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

   /* @ExceptionHandler
    public ResponseEntity<Map<String,Object>> ExceptionHandler(Exception e){
        Map<String, Object> exceptionMap = new HashMap<>();
        exceptionMap.put("code","50");
        exceptionMap.put("message", "捕获到全局异常了");
        return new ResponseEntity<>(exceptionMap,new HttpHeaders(),HttpStatus.OK);
    }*/


    @ExceptionHandler
    @ResponseBody
    public Map<String,Object> ExceptionHandler(Exception e){
        Map<String, Object> exceptionMap = new HashMap<>();
        log.error(ExceptionUtils.getFullStackTrace(e));
        exceptionMap.put("code","501");
        exceptionMap.put("message", "捕获到全局异常了");
        return exceptionMap;
    }
}
