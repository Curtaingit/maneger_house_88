package com.example.manager_house_88;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    public static String currentAuditor = "admin";

    public String getCurrentAuditor() {
        return currentAuditor;
    }


}