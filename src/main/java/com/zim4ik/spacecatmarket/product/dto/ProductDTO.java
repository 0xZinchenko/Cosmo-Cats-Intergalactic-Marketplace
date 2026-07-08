package com.zim4ik.spacecatmarket.product.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(Long id,

                         @NotBlank
                         @Size(max = 256)
                         String name,

                         @NotNull
                         @Positive
                         BigDecimal price) {
}
