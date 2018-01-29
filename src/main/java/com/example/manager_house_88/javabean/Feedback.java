package com.example.manager_house_88.javabean;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Feedback {
    private String createTime;

    private String message;

    private String userId;
    public Feedback(String createTime, String message,String userId) {
        this.createTime = createTime;
        this.message = message;
        this.userId=userId;
    }

    public Feedback () {

    }
}
