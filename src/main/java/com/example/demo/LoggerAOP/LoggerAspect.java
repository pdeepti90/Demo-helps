package com.example.demo.LoggerAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.example.demo.LoggerAOP.CommonJoinPointConfig.businessLayerExecution()")
    public void before(JoinPoint joinPoint) {
        final Signature signature = joinPoint.getSignature();
        logger.info(" Eneter method {} of class {} ",signature.getName() ,signature.getDeclaringType().getName());
    }
    @After("com.example.demo.LoggerAOP.CommonJoinPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint) {
        final Signature signature = joinPoint.getSignature();
        logger.info("Exit method {} of class {}", signature.getName() ,signature.getDeclaringType().getName());
    }

}
