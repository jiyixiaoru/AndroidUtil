package com.wkr.aspectlib;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class NetWorkBehaviorAspect {
    /**
     * 定义切入点
     */
    @Pointcut("execution(@com.wkr.aspectlib.NetWorkBehavior * *(..))")
    public void methodPointCut() {
    }

    @Around("methodPointCut()")
    public Object joinPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log.e("wkr", "========>方法执行前");
        Object proceed = proceedingJoinPoint.proceed();
        Log.e("wkr", "========>方法执行后");
        return proceed;
    }
}
