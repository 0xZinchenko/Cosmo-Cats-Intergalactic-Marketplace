package com.zim4ik.spacecatmarket.product.service;


import com.zim4ik.spacecatmarket.product.dto.ProductDTO;
import com.zim4ik.spacecatmarket.product.exception.ProductNotFoundException;
import com.zim4ik.spacecatmarket.product.mapper.ProductMapper;
import com.zim4ik.spacecatmarket.product.model.Product;
import com.zim4ik.spacecatmarket.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = Product.create(productDTO.name(),
                productDTO.price());
        Product saveProduct = productRepository.save(product);
        ProductDTO dto = productMapper.productToProductDto(saveProduct);
        return dto;
    }

    public List<ProductDTO> getAllProducts() {
            return productRepository.findAll()
                    .stream()
                    .map(productMapper::productToProductDto)
                    .toList();
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.updateName(productDTO.name());
        product.changePrice(productDTO.price());

        Product updatedProduct = productRepository.save(product);

        return productMapper.productToProductDto(updatedProduct);
    }


    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id)
                );

        productRepository.delete(product);

    }
}
