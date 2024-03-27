package com.zemich.catalogueservice.id;

public record ProductCategoryId(long value) {
    public static ProductCategoryId fromParent(long value) {
        return value > 0 ? new ProductCategoryId(value) : null;
    }
}
