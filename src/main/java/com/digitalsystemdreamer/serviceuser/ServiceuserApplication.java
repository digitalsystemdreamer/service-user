package com.digitalsystemdreamer.serviceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class ServiceuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceuserApplication.class, args);
	}

}
