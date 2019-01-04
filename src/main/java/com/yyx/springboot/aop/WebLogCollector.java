package com.yyx.springboot.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.FieldSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Enumeration;

/**
 * @Description: 统一日志收集
 * @Auther: yinyuxin
 * @Date: 2018/11/7 14:48
 */
@Component
@Aspect
@Slf4j
public class WebLogCollector {

    @Pointcut("execution(public * com.yyx.springboot.controller.*.*(..))")
    public void webLogPoint(){

    }

    @Before(value = "webLogPoint()")
    public void doBefore(JoinPoint joinPoint) {
        //接受到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        //收集请求内容
        log.info("URL:"+request.getRequestURI());
        log.info("IP:"+request.getRemoteAddr());
        StringBuffer params=new StringBuffer();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paraKey=parameterNames.nextElement();
            params.append(paraKey).append("=").append(request.getParameter(paraKey)).append(";");
        }
        log.info("PARAMS:{}",params.toString());
    }

    @AfterReturning(returning = "object",pointcut = "webLogPoint()")
    public void doAfterReturning(Object object){
        log.info("RESPONSE:"+JSONObject.toJSONString(object));
    }


}
