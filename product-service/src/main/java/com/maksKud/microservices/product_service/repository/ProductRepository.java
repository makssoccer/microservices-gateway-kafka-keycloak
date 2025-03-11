package com.maksKud.microservices.product_service.repository;

import com.maksKud.microservices.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
     List<Product> findProductsByNameLike(String name);
}
