package com.example.manager_house_88;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;



@EnableJpaAuditing
@SpringBootApplication
public class ManagerHouse88Application {

	public static void main(String[] args) {
		SpringApplication.run(ManagerHouse88Application.class, args);
	}
}
