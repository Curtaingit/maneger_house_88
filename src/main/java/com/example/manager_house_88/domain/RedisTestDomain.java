package com.example.manager_house_88.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RedisTestDomain implements Serializable {

    private String username;

    private String password;

  public  RedisTestDomain(String username,String password){
        this.password=password;
        this.username=username;
    }


}
