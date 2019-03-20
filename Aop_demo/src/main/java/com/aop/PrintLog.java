package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("pl")
@Aspect
public class PrintLog {
    @Pointcut("execution( * com .aop .service .* .*(..))")
    public void ex(){};

    @Before("execution( * com .aop .service .* .*(..))")
    public void before(){
        System.out.println("before");
    }
    @AfterReturning("execution( * com .aop .service .* .*(..))")
    public void afterReturning(){
        System.out.println("AfterReturning");
    }
    @AfterThrowing("execution( * com .aop .service .* .*(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    @After("execution( * com .aop .service .* .*(..))")
    public void after(){
        System.out.println("after");
    }

    @Around("ex()")
    public Object around(ProceedingJoinPoint pjp){
        Object rv = null;
        try {
            Object arg[] = pjp.getArgs();
            System.out.println("前置通知before");
            rv = pjp.proceed(arg);
            System.out.println("后置通知after");
            return rv;
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        }finally {
            System.out.println("最后通知");
        }
        return rv;
    }
}
