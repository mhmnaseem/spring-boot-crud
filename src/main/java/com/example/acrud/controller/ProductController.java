package com.example.acrud.controller;

import com.example.acrud.dto.ProductDTO;
import com.example.acrud.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController
{
    @Autowired
    private ProductServices productServices;

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productServices.saveProduct(productDTO);
    }
    @GetMapping("{id}")
    public ProductDTO fetchByID(@PathVariable Long id){
        return productServices.fetchProductByID(id);
    }
    @GetMapping()
    public List<ProductDTO> fetchAll(){
        return productServices.fetchProductList();
    }
    @PutMapping("{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id) {
        return productServices.updateProduct(productDTO,id);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServices.deleteProductById(id);
        return "Deleted";
    }

}
