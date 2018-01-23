package com.example.manager_house_88.aspect;

import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.utils.ResultVOUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
@RestController
public class ControllerResultAspect {

    private Logger logger = LoggerFactory.getLogger(ControllerResultAspect.class);

    //为了避免每个都需要写长长的路径  使用切点
    @Pointcut("execution(public * com.example.manager_house_88.controller.*.*(..))")
    public void returnResult() {

    }


    /*为所有的Controller类的返回值   做一个统一的处理*/
    @Around("returnResult()")
    public Object doAfter(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();
        //todo :突然出现bug void 不返回东西
        return ResultVOUtil.success(retVal);
    }


}
