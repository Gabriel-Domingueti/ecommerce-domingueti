package com.ecommerce.domingueti.product_api.dto;

import com.ecommerce.domingueti.product_api.model.Category;

import jakarta.validation.constraints.NotBlank;

/**
 * CategoryDTO
 */
public class CategoryDTO {
    @NotBlank 
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());

        return categoryDTO;
    }
}
