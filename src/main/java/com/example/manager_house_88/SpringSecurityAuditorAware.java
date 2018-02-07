package com.example.manager_house_88;

import com.example.manager_house_88.authwechat.SpringUtil;
import com.example.manager_house_88.authwechat.WechatMiniAuthenticationToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;
import java.security.Principal;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

  public static String currentAuditor = "admin";


    public String getCurrentAuditor() {
        return currentAuditor;
     //   SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()

    }

}