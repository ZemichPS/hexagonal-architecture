package com.zemich.catalogueservice.api.spring.webmvc;

import com.zemich.catalogueservice.api.FindProductCategoryInputPort;
import com.zemich.catalogueservice.api.spring.webmvc.presentation.ProductCategoryPresentationV1;
import com.zemich.catalogueservice.id.ProductCategoryId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalogue/product-categories")
public class FindProductCategoryRestController {
    private final FindProductCategoryInputPort inputPort;

    public FindProductCategoryRestController(FindProductCategoryInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(@PathVariable long id) {
        return inputPort.findProductCategory(new ProductCategoryId(id))
                .map(dto -> ResponseEntity.ok(
                        new ProductCategoryPresentationV1(
                                dto.id().value(),
                                dto.title(),
                                dto.details(),
                                dto.parentId() != null ? dto.parentId().value() : null,
                                dto.version()

                        )
                )).orElse(ResponseEntity.notFound().build());
    }


}
