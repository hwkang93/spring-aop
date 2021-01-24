package hwkang.study.springaop.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class MethodInfoAopConfig {

    @Before("execution( * hwkang.study.springaop.user.service.UserServiceImpl.*(..))")
    void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        log.info(" [ " + methodName + " ] start");
    }

    @AfterThrowing(
            pointcut = "execution( * hwkang.study.springaop.user.service.UserServiceImpl.*(..))",
            throwing = "exception"
    )
    void afterThrowing(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();

        if(exception instanceof NullPointerException) {
            log.error(" [ " + methodName + " ] NullPointerException occurred.");
        }
        else {
            log.error(" [ " + methodName + " ] etc Exception occurred.", exception.getMessage());
        }
    }
}
