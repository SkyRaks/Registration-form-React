package com.oliver.Registrationform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RegistrationFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationFormApplication.class, args);
//		int port = Integer.parseInt(System.getenv("PORT"));
//		SpringApplication app = new SpringApplication(RegistrationFormApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port", String.valueOf(port)));
//		app.run(args);
	}

}
