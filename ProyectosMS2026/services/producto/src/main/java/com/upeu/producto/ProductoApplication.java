package com.upeu.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
<<<<<<< HEAD
@EnableFeignClients
=======
@EnableFeignClients(basePackages = "com.upeu.producto.client")
>>>>>>> e30ec6ca0401742abeeeb038f1524e086cd71b1b
public class ProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
	}
}

