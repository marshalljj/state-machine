package com.majian.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Statemachine2Application {

    public static void main(String[] args) {
        SpringApplication.run(Statemachine2Application.class, args);
    }
}
