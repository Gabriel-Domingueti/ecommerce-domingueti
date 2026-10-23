package com.ecommerce.domingueti.product_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domingueti.product_api.dto.ProductDTO;
import com.ecommerce.domingueti.product_api.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/product")
@RequiredArgsConstructor  
public class ProductController {
    private final ProductService productService;
    
    @GetMapping("/")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> products = productService.getAll();
        return products;
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> findByCategoryId(@PathVariable Long categoryId) {
        List<ProductDTO> products = productService.findByCategoryId(categoryId);
        return products;
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping
    public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{id}") 
    public ProductDTO delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
