package com.zkx.house.houseserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class HouseSrvApplication {
	public static void main(String[] args) {
		SpringApplication.run(HouseSrvApplication.class, args);
	}
}
