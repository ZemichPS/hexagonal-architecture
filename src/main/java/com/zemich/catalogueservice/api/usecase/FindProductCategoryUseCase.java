package com.zemich.catalogueservice.api.usecase;

import com.zemich.catalogueservice.api.FindProductCategoryInputPort;
import com.zemich.catalogueservice.dto.ProductCategoryDto;
import com.zemich.catalogueservice.id.ProductCategoryId;
import com.zemich.catalogueservice.spi.FindProductCategoryByIdOutputPort;

import java.util.Optional;
public class FindProductCategoryUseCase implements FindProductCategoryInputPort {

    final private FindProductCategoryByIdOutputPort outputPort;

    public FindProductCategoryUseCase(FindProductCategoryByIdOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public Optional<ProductCategoryDto> findProductCategory(ProductCategoryId id) {
        return this.outputPort.findProductCategoryById(id);
    }
}
