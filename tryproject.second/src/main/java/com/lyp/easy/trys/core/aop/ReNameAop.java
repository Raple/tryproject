package com.lyp.easy.trys.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MemberSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lyp on 2016/10/21.
 */
@Aspect
public class ReNameAop {
    private static Logger logger = LoggerFactory.getLogger("com.etao.cashier.boss.utils.redis.RedisUtil");

    @Around("(@within(com.lyp.easy.trys.entity)&& @annotation(com.lyp.easy.trys.annotation.ReName))")
    public Object getName(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint.getSignature() instanceof MemberSignature) {
            logger.warn("该方法接口无法启用缓存功能", joinPoint.getSignature().toLongString());
            return joinPoint.proceed();
        } else {
            String result="";
            Class targetClass=joinPoint.getTarget().getClass();
            String methodName=joinPoint.getSignature().getName();
            joinPoint.getSignature();

            return result;
        }
    }
}
