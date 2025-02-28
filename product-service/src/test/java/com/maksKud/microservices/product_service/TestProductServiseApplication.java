package com.maksKud.microservices.product_service;

import org.springframework.boot.SpringApplication;

public class TestProductServiseApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
