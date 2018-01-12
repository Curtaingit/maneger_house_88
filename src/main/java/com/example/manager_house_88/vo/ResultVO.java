package com.example.manager_house_88.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
public class ResultVO<T> {

    private ResultVO(){

    }

    private static ResultVO resultVO = new ResultVO();

    public static ResultVO getResultVO(){
        return resultVO;
    }

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;
}
