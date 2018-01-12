package com.example.manager_house_88.aspect;

import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerResultAspect {

    private Logger logger = LoggerFactory.getLogger(ControllerResultAspect.class);

/*
    //Before 表示在方法执行前
    //为所有GirlControl中的方法 注log方法   *表示匹配所有公有方法  ..表示匹配所有参数
    @Before("execution(public * cn.curtain.girl.controller.GirlControl.*(..))")
    public void log(){
        System.out.println("aspect before");
    }

    @After("execution(public * cn.curtain.girl.controller.GirlControl.*(..))")
    public void doAfter(){
        System.out.println("aspect doAfter");
    }
*/

    //为了避免每个都需要写长长的路径  使用切点

    @Pointcut("execution(public * com.example.manager_house_88.controller.*.*(..))")
    public void returnResult() {

    }



/*    @After("returnResult()")
    public void doAfter(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();

        logger.info("aspect doAfter");

    }*/

/*    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}",object.toString());
    }*/

/*    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("aspect before");

        //获取请求的内容

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }*/

}