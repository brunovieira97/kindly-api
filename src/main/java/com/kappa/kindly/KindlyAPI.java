package com.kappa.kindly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.kappa.kindly.model"})
@EnableJpaRepositories(basePackages = {"com.kappa.kindly.repository"})
public class KindlyAPI {

	public static void main(String[] args) {
		SpringApplication.run(KindlyAPI.class, args);
	}

}
