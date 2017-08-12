package com.carry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
@ComponentScan
public class IversonApplication {

	public static void main(String[] args) {
		SpringApplication.run(IversonApplication.class, args);
	}
}
