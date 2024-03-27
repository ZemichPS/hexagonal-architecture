package com.zemich.catalogueservice.api;

import com.zemich.catalogueservice.dto.ProductCategoryDto;
import com.zemich.catalogueservice.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryInputPort {
    Optional<ProductCategoryDto> findProductCategory(ProductCategoryId id);
}
