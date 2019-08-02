package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.FileStorageProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@EnableSwagger2
public class DemoApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
}

