package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lanxw
 */
@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper")
public class ProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class,args);
    }
}
