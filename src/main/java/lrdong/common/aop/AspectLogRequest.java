package lrdong.common.aop;

import com.google.gson.Gson;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class AspectLogRequest {

    private Gson gson =new Gson();
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * lrdong.module..*Controller.*(..))")
    private void controllerAspect(){};

    @Pointcut("execution(* lrdong.module..*Impl.*(..))")
    private void serviceAspect(){};

    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint)
    {
        ServletRequestAttributes servletRequestAttributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        MDC.put("traceid", System.currentTimeMillis()+" ");
        logger.info("url: {} {}",httpServletRequest.getMethod(),httpServletRequest.getRequestURI().trim().toString());
        logger.info("method: {} start {} param: {}",
                joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methodAferReturning(JoinPoint joinPoint,Object o)
    {
        logger.info("method: {} end {} Res: {}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(o));
        MDC.remove("traceid");
    }

    @Before(value = "serviceAspect()")
    public void serviceMethodBefore(JoinPoint joinPoint)
    {
        logger.info("method: {} start {} param:{}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "o",pointcut = "serviceAspect()")
    public void serviceMethodAfter(JoinPoint joinPoint,Object o)
    {
        logger.info("method: {} end {} Res: {}",joinPoint.getSignature(),System.currentTimeMillis(),gson.toJson(o));
    }
}
