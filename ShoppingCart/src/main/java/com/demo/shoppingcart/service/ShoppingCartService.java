package com.demo.shoppingcart.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shoppingcart.dto.ShoppingCartDTO;
import com.demo.shoppingcart.model.Product;
import com.demo.shoppingcart.model.ShoppingCart;
import com.demo.shoppingcart.model.User;
import com.demo.shoppingcart.repository.ProductRepo;
import com.demo.shoppingcart.repository.ShoppingCartRepo;
import com.demo.shoppingcart.repository.UserRepo;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    
    @Autowired
    private ProductRepo productRepo;
    
    @Autowired
    private UserRepo userRepo;

    public List<ShoppingCart> findAll() {
//        return shoppingCartRepo.findAll();
        return shoppingCartRepo.findByStatus("NOT PURCHASED");
    }
    
    public ShoppingCart saveProducts(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = productRepo.findById(shoppingCartDTO.getProductId()).orElse(new Product());
        shoppingCart.setProduct(product);
        shoppingCart.setUser(userRepo.findById(1L).orElse(new User()));
        shoppingCart.setStatus("NOT PURCHASED");
        shoppingCart.setDate(new Date());
        shoppingCart.setQuantity(shoppingCartDTO.getQuantity());
        shoppingCart.setAmount(product.getUnitPrice() * shoppingCartDTO.getQuantity());

        return shoppingCartRepo.save(shoppingCart);
    }
    
    public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        ShoppingCart updateItem = shoppingCartRepo.findById(id).orElse(new ShoppingCart());
        updateItem.setQuantity(shoppingCartDTO.getQuantity());
        updateItem.setAmount(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getQuantity());
        return shoppingCartRepo.save(updateItem);
    }

    public void deleteProduct(Long id) {
        shoppingCartRepo.deleteById(id);
    }

    public void clearShoppingCart(Object object) {
        shoppingCartRepo.deleteAll();
    }


    public List<ShoppingCart> findByPurchased() {
        return shoppingCartRepo.findByStatus("PURCHASED");
    }


    public void purchaseProducts(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepo.findById(id).orElse(new ShoppingCart());
        shoppingCart.setStatus("PURCHASED");
        shoppingCartRepo.save(shoppingCart);
    }
    
    
}
