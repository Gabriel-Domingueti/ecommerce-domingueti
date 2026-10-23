package com.ecommerce.domingueti.product_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domingueti.product_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
