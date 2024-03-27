package com.zemich.catalogueservice.spi;

import com.zemich.catalogueservice.dto.ProductCategoryDto;
import com.zemich.catalogueservice.id.ProductCategoryId;

import java.util.Optional;
@FunctionalInterface
public interface FindProductCategoryByIdOutputPort {
    Optional<ProductCategoryDto> findProductCategoryById(ProductCategoryId id);
}
