package com.productservice.Exception;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(Integer Id){
        super("Product not found with id:"+Id);
    }
    public ProductNotFoundException(String name){
        super("Product not found with name:"+name);
    }
}
