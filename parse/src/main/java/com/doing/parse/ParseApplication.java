package com.doing.parse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class ParseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParseApplication.class, args);
	}

}

