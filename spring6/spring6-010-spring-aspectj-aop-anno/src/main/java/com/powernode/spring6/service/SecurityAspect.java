package com.powernode.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 动力节点
 * @version 1.0
 * @className SecurityAspect
 * @since 1.0
 **/
@Aspect
@Component
@Order(0) // 数字越小，优先级越高。
public class SecurityAspect { // 安全切面

    // 通知 + 切点
    //@Before("execution(* com.powernode.spring6.service..*(..))")
    @Before("com.powernode.spring6.service.LogAspect.通用切点()")
    public void beforeAdvice(){
        System.out.println("前置通知：安全...");
    }

}
