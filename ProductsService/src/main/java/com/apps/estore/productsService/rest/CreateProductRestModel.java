package com.apps.estore.productsService.rest;

import lombok.*;

import java.math.BigDecimal;


@Data
public class CreateProductRestModel {

    private String title;
    private BigDecimal price;
    private  Integer quantity;



}
