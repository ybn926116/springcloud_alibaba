package org.hope.hopestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HopeStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopeStorageApplication.class, args);
	}

}
