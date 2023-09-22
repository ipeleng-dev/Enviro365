package com.enviro.assessment.grad001.ipelenglebelo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.enviro.assessment.grad001.ipelenglebelo.demo")
public class EnviroApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviroApplication.class, args);
	}

}
