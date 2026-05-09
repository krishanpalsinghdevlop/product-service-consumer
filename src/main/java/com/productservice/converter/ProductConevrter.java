package com.productservice.converter;

import com.productservice.enity.Product;
import com.productservice.mdel.ProductRequest;
import com.productservice.mdel.ProductResponse;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductConevrter {


    public Product convert(ProductRequest productRequest) {
  return         Product.builder()
                .productId(productRequest.getProductId())
                .onlinefrom(productRequest.getOnlineFrom())
                .onlineTo(productRequest.getOnlineTo())
                .updatedOn(LocalDateTime.now())
                .createdOn(LocalDateTime.now())
                .name(productRequest.getName())
                .color(productRequest.getColor())
                .category(productRequest.getCategory()).build();
    }

    public ProductResponse getProductResponse(Product product){
        return ProductResponse.builder()
                .productId(product.getProductId())
                .onlineFrom(product.getOnlinefrom())
                .onlineTo(product.getOnlineTo())
                .updatedOn(product.getUpdatedOn())
                .createdOn(product.getCreatedOn())
                .name(product.getName())
                .color(product.getColor())
                .category(product.getCategory())
                .build();
    }
}
