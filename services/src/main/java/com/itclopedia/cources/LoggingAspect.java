package com.itclopedia.cources;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.itclopedia.cources..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Метод: {} с аргументами: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.itclopedia.cources..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Метод {} возвращает значения: {}", joinPoint.getSignature(), result);
    }

    @Around("execution(* com.itclopedia.cources..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            logger.info("Метод: {} выполнен за {} с результатом: {}", joinPoint.getSignature(), executionTime, proceed);
            return proceed;
        } catch (Throwable e) {
            logger.error("Метод: {} выдал ошибку: {}", joinPoint.getSignature(), e.getMessage());
            throw e;
        }
    }
}
