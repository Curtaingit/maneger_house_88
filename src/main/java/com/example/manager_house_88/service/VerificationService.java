package com.example.manager_house_88.service;

import com.aliyuncs.exceptions.ClientException;

public interface VerificationService {

    void getCode(String number,String userId) throws ClientException;

    void sendCode(String code,String number,String userId);
}
