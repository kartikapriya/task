package com.demo.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shoppingcart.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {


}
