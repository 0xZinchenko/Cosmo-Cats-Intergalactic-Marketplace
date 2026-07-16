package com.zim4ik.spacecatmarket.product.mapper;

import com.zim4ik.spacecatmarket.product.dto.ProductDTO;
import com.zim4ik.spacecatmarket.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductDTO productToProductDto(Product product);

}
