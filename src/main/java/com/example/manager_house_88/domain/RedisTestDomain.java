package com.example.manager_house_88.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedisTestDomain {

    private String username;

    private String password;

  public  RedisTestDomain(String username,String password){
        this.password=password;
        this.username=username;
    }


}
