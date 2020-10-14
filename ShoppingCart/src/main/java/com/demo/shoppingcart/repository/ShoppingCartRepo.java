package com.demo.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shoppingcart.model.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {

	List<ShoppingCart> findByStatus(String string);

}
