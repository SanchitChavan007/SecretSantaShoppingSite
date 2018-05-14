package com.me.secretsanta.model;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.me.secretsanta.pojo.Product;
 
public class ProductInfo {
    private int code;
    private String name;
    private double price;
 
    private boolean newProduct=false;
 
   
 
    public ProductInfo() {
    }
 
    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }
 

    public ProductInfo(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
 
    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
  
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}