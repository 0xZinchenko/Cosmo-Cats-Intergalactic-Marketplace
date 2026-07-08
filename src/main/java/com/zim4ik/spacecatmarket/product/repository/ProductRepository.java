package com.zim4ik.spacecatmarket.product.repository;

import com.zim4ik.spacecatmarket.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
