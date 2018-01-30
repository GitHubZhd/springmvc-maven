package com.example.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class DispatcherAspect {

    private static final Logger logger =  LoggerFactory.getLogger(DispatcherAspect.class);


    @Before("execution(** com.example.controller.HomeController.*(..))")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<====================================================================");
        logger.info("请求URL: " + request.getRequestURL().toString());
        logger.info("请求IP: " + request.getRemoteAddr().toString());
        logger.info("<====================================================================");
    }
}