package com.ing.mortgages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MortgagesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MortgagesApplication.class, args);
	}

}
