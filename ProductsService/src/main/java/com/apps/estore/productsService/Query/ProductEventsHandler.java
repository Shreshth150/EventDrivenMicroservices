package com.apps.estore.productsService.Query;

import com.apps.estore.productsService.core.Event.ProductCreatedEvent;
import com.apps.estore.productsService.core.data.ProductEntity;
import com.apps.estore.productsService.core.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent , productEntity);

        productRepository.save(productEntity);
    }

}
