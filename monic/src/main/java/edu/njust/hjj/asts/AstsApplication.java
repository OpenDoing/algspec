package edu.njust.hjj.asts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("edu.njust.hjj.asts.dao.*")
//@EnableDiscoveryClient
public class AstsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstsApplication.class, args);
	}
}
