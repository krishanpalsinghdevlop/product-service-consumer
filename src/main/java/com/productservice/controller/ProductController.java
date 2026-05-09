package com.productservice.controller;

import com.productservice.converter.ProductConevrter;
import com.productservice.enity.Product;
import com.productservice.mdel.ProductRequest;
import com.productservice.mdel.ProductResponse;
import com.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Log4j2
public class ProductController {
    @Autowired
    ProductService productService;

    @PutMapping
   public ResponseEntity<String> updateProduct(@RequestBody ProductRequest productRequest){

        log.info("Received product with productID = " + productRequest.getProductId());
        productService.save(productRequest);
        return new ResponseEntity<>("Updated",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Integer id){
        ProductResponse productResponse = productService.getProduct(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<ProductResponse>> getProductByCategory(@RequestParam("color") String color, @RequestParam("name") String name  ){
        List<ProductResponse> productResponses = productService.getProductByNameAndColor(name,color);
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }
}
