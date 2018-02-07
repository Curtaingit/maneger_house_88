package com.example.manager_house_88.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.service.VerificationService;
import com.example.manager_house_88.utils.AliyunMessageUtil;
import com.example.manager_house_88.utils.NumberUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired

    private ScheduleService scheduleService;

    @Override
    public void getCode(String number, String userId) throws ClientException {

        String randomNum = NumberUtil.createRandomNum(6);
        String jsonContent = "{\"code\":\"" + randomNum + "\"}";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("phoneNumber", number);
        paramMap.put("msgSign", "温州房产圈");
        paramMap.put("templateCode", "SMS_125025751");
        paramMap.put("jsonContent", jsonContent);
        SendSmsResponse sendSmsResponse = AliyunMessageUtil.sendSms(paramMap);
        if (!(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))) {
            if (sendSmsResponse.getCode() == null) {
                throw new ManagerHouse88Exception(ResultExceptionEnum.CODE_NOT_TRUE.getMessage());
            }
            if (!sendSmsResponse.getCode().equals("OK")) {
                throw new ManagerHouse88Exception(ResultExceptionEnum.DO_NOT_PASS);
            }
        }
        redisTemplate.opsForValue().set(userId + number, randomNum);
    }

    @Override
    public void sendCode(String code, String userId, String number) {
        String s = userId + number;
        String rs = (String) redisTemplate.opsForValue().get(s);
        if (rs.equals(code)) {
            redisTemplate.delete(s);
        } else {
            throw new ManagerHouse88Exception(ResultExceptionEnum.DO_NOT_PASS.getMessage());
        }

    }


}

