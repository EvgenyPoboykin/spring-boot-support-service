package com.company.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SupportApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplicationBuilder(SupportApplication.class).build();
		application.run(args);

	}
}
