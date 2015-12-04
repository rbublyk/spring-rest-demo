package com.dataart.rbublyk;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger
public class DemoRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }
}
