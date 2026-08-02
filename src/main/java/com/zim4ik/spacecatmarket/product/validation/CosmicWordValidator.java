package com.zim4ik.spacecatmarket.product.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Locale;

public class CosmicWordValidator implements ConstraintValidator<CosmicWordCheck, String> {

    private static final List<String> COSMIC_WORDS = List.of("star", "galaxy", "comet");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        String normalized = value.toLowerCase(Locale.ROOT);

        return COSMIC_WORDS.stream()
                .anyMatch(normalized::contains);
    }
}
