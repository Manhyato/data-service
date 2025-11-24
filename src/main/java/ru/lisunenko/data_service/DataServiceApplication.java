package ru.lisunenko.data_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.lisunenko.data_service")
@EntityScan(basePackages = "ru.lisunenko.data_service.service")
@EnableJpaRepositories(basePackages = "ru.lisunenko.data_service.service")
public class DataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
    }

}

