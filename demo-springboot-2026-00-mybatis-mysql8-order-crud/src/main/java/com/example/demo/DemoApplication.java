
package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner printSwaggerLinks() {
        return args -> {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Access Swagger UI: http://localhost:8080/swagger-ui/index.html");
            System.out.println("Access OpenAPI Docs: http://localhost:8080/v3/api-docs");
            System.out.println("----------------------------------------------------------\n");
        };
    }
}
