package com.example.manager_house_88.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {


    private String appId;

    private String secret;

    private String mchId;

    private String mchKey;

    private String keyPath;

    private String notifyUrl;

}
