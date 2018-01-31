package com.example.manager_house_88;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Service;


@EnableOAuth2Client
@EnableJpaAuditing
@SpringBootApplication
public class ManagerHouse88Application {

	public static void main(String[] args) {
		SpringApplication.run(ManagerHouse88Application.class, args);
	}
}
