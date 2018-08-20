package de.god.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogReturnValueAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(LogReturnValue)")
    public Object afterReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Enter Aspect 'LogReturnValue'");
        Object proceed = joinPoint.proceed();
        logger.info("Returned value was: ", proceed);
        return proceed;
    }
}
