package com.zemich.catalogueservice.spi.spring.jdbc;

import com.zemich.catalogueservice.dto.ProductCategoryDto;
import com.zemich.catalogueservice.id.ProductCategoryId;
import com.zemich.catalogueservice.spi.FindProductCategoryByIdOutputPort;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;


public class MappingSqlQueryJdbcClientFindProductCategoryById
        extends MappingSqlQuery<ProductCategoryDto> implements FindProductCategoryByIdOutputPort {

    public MappingSqlQueryJdbcClientFindProductCategoryById(DataSource ds) {

        super(ds, """
                        SELECT id, c_title, c_details, id_parent, c_version
                        FROM catalogue.v_product_category_v1
                        WHERE id = :id
                """);
        this.declareParameter(new SqlParameter("id", Types.BIGINT));
        this.compile();
    }

    @Override
    public Optional<ProductCategoryDto> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(this.findObjectByNamedParam(Map.of("id", id)));
    }

    @Override
    protected ProductCategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductCategoryDto(
                new ProductCategoryId(rs.getLong("id")),
                rs.getString("c_title"),
                rs.getString("c_details"),
                ProductCategoryId.fromParent(rs.getLong("id_parent")),
                rs.getInt("c_version")
        );
    }
}
