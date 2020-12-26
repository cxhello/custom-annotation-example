package com.cxhello.example.aspect;

import com.cxhello.example.annotion.ExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author cxhello
 * @create 2020/12/26
 */
@Aspect
@Component
public class ExecutionTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(com.cxhello.example.annotion.ExecutionTime)")
    public Object recordExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        Method method = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod();
        ExecutionTime annotation = method.getAnnotation(ExecutionTime.class);
        logger.info(annotation.methodDescription() + "执行时长: {}", endTime - startTime);
        return result;
    }

}
