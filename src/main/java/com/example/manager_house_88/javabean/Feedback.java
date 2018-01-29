package com.example.manager_house_88.javabean;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Feedback implements Serializable {

    private String message;

    private String time;

    private String userId;

    public Feedback(String message, String time, String userId) {
        this.message = message;
        this.time = time;
        this.userId = userId;
}

    public Feedback() {
    }
}
