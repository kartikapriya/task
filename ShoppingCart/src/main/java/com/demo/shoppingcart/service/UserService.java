package com.demo.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shoppingcart.model.User;
import com.demo.shoppingcart.repository.UserRepo;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L,"user1@gmail.com","user1"));
        users.add(new User(2L,"user2@gmail.com","user2"));
    }

    public void saveData(){
        userRepo.saveAll(users);
    }

}
