package com.apps.estore.productsService.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity , String> {

    Optional<ProductEntity> findByProductId(String productId);
    Optional<ProductEntity> findByProductIdOrTitle(String productId , String title);

}
