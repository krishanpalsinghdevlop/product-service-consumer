package com.productservice.service;

import com.productservice.Exception.ProductNotFoundException;
import com.productservice.converter.ProductConevrter;
import com.productservice.enity.Product;
import com.productservice.mdel.ProductRequest;
import com.productservice.mdel.ProductResponse;
import com.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductConevrter productConevrter;
    public void save(ProductRequest productRequest){
        Product product =null ;
        try {
             product = (productConevrter.convert(productRequest));
            productRepository.save(product);
        }catch(Exception e)  {
            log.info("Exception ocurred while saving product: {} " ,product, e);
        }
          }


    public ProductResponse getProduct(Integer produtId){
       Product product = productRepository.findById(produtId).orElseThrow(() -> new ProductNotFoundException(produtId));
       return productConevrter.getProductResponse(product);
    }
    public List<ProductResponse> getProductByNameAndColor(String name, String color){
        List<Product> products = productRepository.findByNameAndColor(name,color);
        if(products.isEmpty()){
            throw  new ProductNotFoundException("name");
        }
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product: products){
            productResponses.add(productConevrter.getProductResponse(product));
        }
        return productResponses;
    }
}
