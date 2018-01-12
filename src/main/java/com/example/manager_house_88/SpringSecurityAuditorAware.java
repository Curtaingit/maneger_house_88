package com.example.manager_house_88;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    public static String currentAuditor = "admin";

    public String getCurrentAuditor() {
        return currentAuditor;
    }

}
