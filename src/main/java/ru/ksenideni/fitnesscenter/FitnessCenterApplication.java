package ru.ksenideni.fitnesscenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FitnessCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessCenterApplication.class, args);
    }

}
