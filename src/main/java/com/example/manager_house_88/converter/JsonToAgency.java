package com.example.manager_house_88.converter;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonToAgency {
    public static Agency convert(String agency) {
        Agency result;
        Gson gson = new Gson();

        try {
            result = gson.fromJson(agency, new TypeToken<Agency>() {
            }.getType());
        } catch (Exception e) {
            log.error("对象转化错误  string={}",agency);
            throw new ManagerHouse88Exception("Agency转化失败");
        }
        return result;
    }
}
