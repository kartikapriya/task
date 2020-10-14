package com.demo.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shoppingcart.model.Product;
import com.demo.shoppingcart.repository.ProductRepo;

@Service
@Transactional
public class ProductService{

    @Autowired
    private ProductRepo productRepo;

    private static List<Product> products = new ArrayList<>();

    static {
    	products.add(new Product(85000.0d,800,"Imported Canon camera from USA","Camera"));
    	products.add(new Product(300.0d,800,"Head and Shoulders Shampoo","Shampoo"));
    	products.add(new Product(450.0d,800,"Hot Water Bottles","Bottle"));
    	products.add(new Product(1000.0d,400,"Imported Leather bag","Office Bag"));
    	products.add(new Product(550.0d,800,"Leather Wallets imported from AUS","Leather Wallets"));
    	products.add(new Product(45000.0d,800,"3G/4G capability","Mobile Phone"));    	
        products.add(new Product(35.75d,1000,"Baby soap for Kids","Soap"));
        products.add(new Product(45.50d,500,"Soft Bristles for babies","Tooth Brushe"));
        products.add(new Product(1500.0d,100,"Casual Shirt","Shirt"));        
        products.add(new Product(2500.0d,800,"Imported wrist watches from swiss","Wrist Watch"));       
    }

    public void saveData(){
        productRepo.saveAll(products);
    }

    public List<Product> findAll(){
        return productRepo.findAll();
    }
}

