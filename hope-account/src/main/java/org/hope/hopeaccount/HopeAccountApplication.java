package org.hope.hopeaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HopeAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopeAccountApplication.class, args);
    }

}
