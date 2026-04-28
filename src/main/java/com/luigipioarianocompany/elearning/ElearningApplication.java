package com.luigipioarianocompany.elearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//TODO: TOGLIERE EAGER E METTERE LAZY NELLE RELAZIONI DOVE SERVE
public class ElearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearningApplication.class, args);
	}

}
