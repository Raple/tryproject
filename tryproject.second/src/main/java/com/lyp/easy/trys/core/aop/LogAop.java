package com.lyp.easy.trys.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by lyp on 2016/10/10.
 */
@Order(1)
@Aspect
@Component
public class LogAop {
    private static Logger loggerController = LoggerFactory.getLogger("com.lyp.easy.trys.core.aop.controller");
    private static Logger loggerService = LoggerFactory.getLogger("com.lyp.easy.trys.core.aop.service");

    /**
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("bean(*Controller)")
    public void expressionControllerLog() {
    }

    ;

    @Pointcut("bean(*ServiceImpl)")
    public void expressionServiceLog() {
    }

    ;

//    @Pointcut("bean(*Dao)")
//    public void expressionDaoLog() {
//    }
//
//    ;

    /**
     * 配置前置通知
     *
     * @param joinPoint
     */
    @Before("expressionControllerLog()")
    public void beforeController(JoinPoint joinPoint) {
        try {
            if (loggerController.isInfoEnabled()) {
                loggerController.info(String.format("Class:%s Params:%s", joinPoint.getSignature(), getArgs(joinPoint)));
            }
        } catch (Exception e) {
        }
    }

    @Before("expressionServiceLog()")
    public void beforeService(JoinPoint joinPoint) {
        try {
            if (loggerService.isInfoEnabled()) {
                loggerService.info(String.format("Class:%s Params:%s", joinPoint.getSignature(), getArgs(joinPoint)));
            }
        } catch (Exception e) {
        }
    }

    /**
     * 配置后置返回通知
     *
     * @param joinPoint
     */
    @AfterReturning(value = "expressionControllerLog()", returning = "result")
    public void afterController(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String Json =  mapper.writeValueAsString(result);

        try {
            if (loggerController.isInfoEnabled()) {
                loggerController.debug(String.format("Class:%s Return:%s", joinPoint.getSignature(), Json));
            }
        } catch (Exception e) {
        }
    }

    @AfterReturning(value = "expressionServiceLog()", returning = "result")
    public void afterService(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String Json =  mapper.writeValueAsString(result);
        try {
            if (loggerService.isInfoEnabled()) {
                loggerService.debug(String.format("Class:%s Return:%s", joinPoint.getSignature(), Json));
            }
        } catch (Exception e) {
        }
    }

    private String getArgs(JoinPoint joinPoint) {
        return Arrays.toString(joinPoint.getArgs());
    }
}