package com.example.manager_house_88;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    public String getCurrentAuditor() {
        return "11111111111111111111";
    }

}
