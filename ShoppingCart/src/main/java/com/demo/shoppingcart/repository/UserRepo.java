package com.demo.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.shoppingcart.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
}
