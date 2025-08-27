package com.example.zidio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
public class EmailServiceApplication {

    public static void main(String[]args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }


}
