package com.example.manager_house_88.handler;

import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ManagerHouse88ExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public ResultVO handler(Exception e){
        log.info("Controller : " + e.getMessage());
        return ResultVOUtil.error(e.getMessage());
    }
}
