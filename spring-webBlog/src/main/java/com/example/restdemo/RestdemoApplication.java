package com.example.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableJpaRepositories("com")
@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableSwagger2
//@EnableKafka
public class RestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
	}

}
