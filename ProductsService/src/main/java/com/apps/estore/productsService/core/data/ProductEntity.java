package com.apps.estore.productsService.core.data;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Document(collection = "products")
public class ProductEntity implements Serializable {

    private String productId;
    private String title ;
    private BigDecimal price;
    private Integer quantity;



}
