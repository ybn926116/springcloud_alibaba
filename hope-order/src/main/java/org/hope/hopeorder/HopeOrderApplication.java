package org.hope.hopeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HopeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopeOrderApplication.class, args);
	}

}
