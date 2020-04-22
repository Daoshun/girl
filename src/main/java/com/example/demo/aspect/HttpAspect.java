package com.example.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Daoshun
 * 2020/4/13 10:22
 */
// 定义切面和切点
@Aspect
// 引入到spring 容器中
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // 点切，切入的哪个点
    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("1111111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    // 全部用*所用的方法 (..)代表里面任何参数
    @After("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void doAfter() {

        logger.info("日志输出后检验");
        System.out.println("后检验！");
    }
    // 输出显示的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
