package com.luisbilecki.openfeignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignExampleApplication.class, args);
	}

}
