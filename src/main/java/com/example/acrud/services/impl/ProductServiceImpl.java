package com.example.acrud.services.impl;

import com.example.acrud.dto.ProductDTO;
import com.example.acrud.entity.Product;
import com.example.acrud.exception.ResourceNotFoundException;
import com.example.acrud.mapper.ProductMapper;
import com.example.acrud.repository.ProductRepository;
import com.example.acrud.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        var raw=ProductMapper.mapToEntity(productDTO);
        var saved =productRepository.save(raw);
        return ProductMapper.mapToDto(saved);
    }

    @Override
    public List<ProductDTO> fetchProductList() {
        return productRepository.findAll().stream().map(ProductMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("NOT FOUND")
        );
        var raw=ProductMapper.mapToEntity(productDTO);
        existingProduct.setName(raw.getName());
        existingProduct.setQty(raw.getQty());
        existingProduct.setStock(raw.getStock());
        Product savedProduct = productRepository.save(existingProduct);
        return ProductMapper.mapToDto(savedProduct);
    }

    @Override
    public void deleteProductById(Long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("NOT FOUND")
        );
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDTO fetchProductByID(Long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("NOT FOUND")
        );
        return ProductMapper.mapToDto(existingProduct);
    }
}
