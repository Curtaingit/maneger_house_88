package com.example.manager_house_88.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultVO<T> {
    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;
}
