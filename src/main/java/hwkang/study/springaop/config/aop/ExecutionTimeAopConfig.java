package hwkang.study.springaop.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
@Slf4j
public class ExecutionTimeAopConfig {

    @Around("@annotation(hwkang.study.springaop.annotation.ExecutionTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getClass().getSimpleName();
        String methodName = methodSignature.getMethod().getName();

        StopWatch stopWatch = new StopWatch(className + "." + methodName);
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        long executionTime = stopWatch.getTotalTimeMillis();

        log.info(" [ " + stopWatch.getId() + " ] execution time is [ " + executionTime + " ] ms.");

        return result;
    }
}
