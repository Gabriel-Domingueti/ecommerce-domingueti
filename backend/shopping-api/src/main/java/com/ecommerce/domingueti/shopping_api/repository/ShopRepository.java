package com.ecommerce.domingueti.shopping_api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domingueti.shopping_api.model.Shop;
 
public interface ShopRepository extends JpaRepository<Shop, Long> {
    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(Double total);
    public List<Shop> findAllByDateGreaterThan(Date date);
}
