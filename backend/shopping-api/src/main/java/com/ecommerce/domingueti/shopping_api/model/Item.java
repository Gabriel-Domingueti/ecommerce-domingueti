package com.ecommerce.domingueti.shopping_api.model;

import com.ecommerce.domingueti.shopping_api.dto.ItemDTO;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Item {
    private String productIdentifier;
    private Double price;

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
