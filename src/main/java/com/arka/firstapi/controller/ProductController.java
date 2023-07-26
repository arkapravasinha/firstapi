package com.arka.firstapi.controller;

import com.arka.firstapi.exceptions.ProductNotFoundException;
import com.arka.firstapi.models.ProductCreateDTO;
import com.arka.firstapi.models.ProductResponseDTO;
import com.arka.firstapi.models.ProductUpdateDTO;
import com.arka.firstapi.services.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/products")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path="/allproducts")
    HttpEntity<Collection<ProductResponseDTO>> getAllProducts()
    {
        log.info("Called Products");
        Collection<ProductResponseDTO> products=productService.getProducts();
        if(products==null || products.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Collection<ProductResponseDTO>>(products,HttpStatus.OK) ;
    }

    @PostMapping
    ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO)
    {
        log.info("Called Create Products");
        return new ResponseEntity<>(productService.createProduct(productCreateDTO),HttpStatus.CREATED);

    }

    @GetMapping(path = "/{id}")
    ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") Long id ) throws ProductNotFoundException {
        log.info("Called Get Products");
        return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);

    }

    @PutMapping
    ResponseEntity<ProductResponseDTO> updateProduct(@Valid @RequestBody ProductUpdateDTO productUpdateDTO) throws ProductNotFoundException {
        log.info("Called Update Products");
        return new ResponseEntity<>(productService.updateProduct(productUpdateDTO),HttpStatus.CREATED);

    }
}
