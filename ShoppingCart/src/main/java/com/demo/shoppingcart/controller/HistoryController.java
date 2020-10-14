package com.demo.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shoppingcart.model.ShoppingCart;
import com.demo.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ShoppingCart> getAll(){
        return shoppingCartService.findByPurchased();
    }


}

