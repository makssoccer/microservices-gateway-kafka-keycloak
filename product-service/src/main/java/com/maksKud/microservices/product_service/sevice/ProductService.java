package com.maksKud.microservices.product_service.sevice;

import com.maksKud.microservices.product_service.dto.ProductRequest;
import com.maksKud.microservices.product_service.dto.ProductResponse;
import com.maksKud.microservices.product_service.model.Product;
import com.maksKud.microservices.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .brand(productRequest.brand())
                .description(productRequest.description())
                .build();
        productRepository.save(product);

        log.info("Product created: {}", product);
        return new ProductResponse(product.getId(), product.getName(),
                product.getBrand(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),
                        product.getBrand(), product.getDescription(), product.getPrice()))
                .toList();
    }

    public List<ProductResponse> getProductsForName(String name) {
        return productRepository.findProductsByNameLike(name)
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),
                        product.getBrand(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
