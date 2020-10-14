package com.demo.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.shoppingcart.service.ProductService;
import com.demo.shoppingcart.service.UserService;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ShoppingCartApplication.class, args);
		
		ProductService productService = applicationContext.getBean(ProductService.class);
		productService.saveData();
		
		UserService userService = applicationContext.getBean(UserService.class);
		userService.saveData();
		
	}

}
