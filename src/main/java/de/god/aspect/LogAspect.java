package de.god.aspect;

import de.god.logger.LogMessageBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Aspect
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut - condition when to trigger
    @Around("@annotation(LogReturnValue)")
    // Joinpoint - moment of program flow
    public Object afterReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("##### @Around(\"@annotation(LogReturnValue)\")");
        logger.info("##### The method '" + joinPoint.getSignature() + "' was called");
        return joinPoint.proceed();
    }

    @Around("execution(* de.god.special..*.*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("##### @Around(\"execution(* de.god.special..*.*(..))\")");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object returnValue = joinPoint.proceed();
        stopWatch.stop();

        logger.info(new LogMessageBuilder()
                .clazz(joinPoint.getTarget().getClass().getName())
                .method(joinPoint.getSignature().getName())
                .methodsParams(joinPoint.getArgs())
                .build()
        );
        return returnValue;
    }
}
