package com.example.acrud.services;

import com.example.acrud.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServices {
    // Save operation
    ProductDTO saveProduct(ProductDTO product);

    // Read operation
    List<ProductDTO> fetchProductList();

    // Update operation
    ProductDTO updateProduct(ProductDTO product,
                                Long productId);

    // Delete operation
    void deleteProductById(Long productId);

    ProductDTO fetchProductByID(Long productId);
}
