package com.zim4ik.spacecatmarket.product.controller;

import com.zim4ik.spacecatmarket.product.dto.ProductDTO;
import com.zim4ik.spacecatmarket.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
       return productService.createProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

   @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
   }


}
