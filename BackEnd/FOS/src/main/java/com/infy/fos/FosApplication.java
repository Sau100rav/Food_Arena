package com.infy.fos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"com.infy.fos"})
public class FosApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FosApplication.class, args);
	}

}
