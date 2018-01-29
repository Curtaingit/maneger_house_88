package com.example.manager_house_88.javabean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Setter
@Getter
public class Message implements Serializable{

    private String createTime;

    private String message;

    public Message(String createTime, String message) {
        this.createTime = createTime;
        this.message = message;
    }

    public Message() {

    }
}
