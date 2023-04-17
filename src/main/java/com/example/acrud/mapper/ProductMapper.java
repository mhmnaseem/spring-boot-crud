package com.example.acrud.mapper;

import com.example.acrud.dto.ProductDTO;
import com.example.acrud.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setQty(product.getQty());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    public static Product mapToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQty(productDTO.getQty());
        product.setStock(productDTO.getStock());
        return product;
    }
}
