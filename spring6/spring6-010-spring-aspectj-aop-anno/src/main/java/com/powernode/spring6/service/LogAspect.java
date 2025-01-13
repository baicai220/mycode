package com.powernode.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 动力节点
 * @version 1.0
 * @className LogAspect
 * @since 1.0
 **/
@Component("logAspect")
@Aspect // 切面类是需要使用@Aspect注解进行标注的。
@Order(2)
public class LogAspect { // 切面

    // 切面 = 通知 + 切点
    // 通知就是增强，就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现。（因为方法中可以写代码）
    // @Before注解标注的方法就是一个前置通知。
    /*@Before("execution(* com.powernode.spring6.service..*(..))")
    public void 增强(){
        System.out.println("我是一个通知，我是一段增强代码....");
    }*/

    // 定义通用的切点表达式
    @Pointcut("execution(* com.powernode.spring6.service..*(..))")
    public void 通用切点(){
        // 这个方法只是一个标记，方法名随意，方法体中也不需要写任何代码。
    }

    // 前置通知
    @Before("通用切点()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
        // 这个JoinPoint joinPoint，在Spring容器调用这个方法的时候自动传过来.
        // 我们可以直接用。用这个JoinPoint joinPoint干啥？
        // Signature signature = joinPoint.getSignature(); 获取目标方法的签名。
        // 通过方法的签名可以获取到一个方法的具体信息。
        // 获取目标方法的方法名。
        System.out.println("目标方法的方法名：" + joinPoint.getSignature().getName());
    }

    // 后置通知
    @AfterReturning("通用切点()")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("后置通知");
    }

    // 环绕通知(环绕是最大的通知，在前置通知之前，在后置通知之后。)
    @Around("通用切点()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面的代码
        System.out.println("前环绕");
        // 执行目标
        joinPoint.proceed(); // 执行目标
        // 后面的代码
        System.out.println("后环绕");
    }

    // 异常通知
    @AfterThrowing("通用切点()")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    // 最终通知 (finally语句块中的通知)
    @After("通用切点()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}






















