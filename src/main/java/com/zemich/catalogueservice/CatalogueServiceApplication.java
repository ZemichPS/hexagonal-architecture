package com.zemich.catalogueservice;

import com.zemich.catalogueservice.api.usecase.FindProductCategoryUseCase;
import com.zemich.catalogueservice.spi.spring.jdbc.MappingSqlQueryJdbcClientFindProductCategoryById;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CatalogueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueServiceApplication.class, args);
    }

    @Bean
    FindProductCategoryUseCase findProductCategoryUseCase(DataSource dataSource) {
        return new FindProductCategoryUseCase(
                new MappingSqlQueryJdbcClientFindProductCategoryById(dataSource
        ));
    }



}
