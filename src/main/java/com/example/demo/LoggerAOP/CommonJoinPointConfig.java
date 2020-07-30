package com.example.demo.LoggerAOP;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


public class CommonJoinPointConfig {
    @Pointcut(value="execution(* com.example.demo.repository.*.*(..))")
    public void dataLayerExecution() {}
    @Pointcut(value="execution(* com.example.demo.service.*.*(..))")
    public void businessLayerExecution() {}
}