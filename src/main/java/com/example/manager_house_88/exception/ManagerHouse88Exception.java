package com.example.manager_house_88.exception;

import com.example.manager_house_88.enums.ResultExceptionEnum;

public class ManagerHouse88Exception extends RuntimeException {

    public ManagerHouse88Exception(String msg){
        super(msg);
    }

    public ManagerHouse88Exception(ResultExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
    }

    public ManagerHouse88Exception(ResultExceptionEnum exceptionEnum,String msg){
        super(exceptionEnum.getMessage()+", "+msg);
    }

}
