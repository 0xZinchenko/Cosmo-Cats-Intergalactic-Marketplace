package com.zim4ik.spacecatmarket.product.service;


import com.zim4ik.spacecatmarket.product.dto.ProductDTO;
import com.zim4ik.spacecatmarket.product.mapper.ProductMapper;
import com.zim4ik.spacecatmarket.product.model.Product;
import com.zim4ik.spacecatmarket.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductDTO createProduct(ProductDTO productDTO) {
        Product entity = productMapper.toEntity(productDTO);
        Product saveProduct = productRepository.save(entity);
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
                .orElseThrow(() -> new IllegalArgumentException("Product not found:" + id));
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product nit found" + id));

        product.changePrice(productDTO.price());
        product.rename(productDTO.name());

        Product updatedProduct = productRepository.save(product);

        return productMapper.productToProductDto(updatedProduct);
    }


    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Not found" + id)
                );

        productRepository.delete(product);

    }
}
