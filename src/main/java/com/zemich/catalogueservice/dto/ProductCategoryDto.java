package com.zemich.catalogueservice.dto;

import com.zemich.catalogueservice.id.ProductCategoryId;

public record ProductCategoryDto(ProductCategoryId id,
                                 String title,
                                 String details,
                                 ProductCategoryId parentId,
                                 int  version
                                 ) {
}
