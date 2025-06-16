package com.swlo.distribuitioncenter.services;

import com.swlo.distribuitioncenter.business.clients.HubClient;
import com.swlo.distribuitioncenter.entities.ProductEntity;
import com.swlo.distribuitioncenter.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final HubClient hubClient;

    public ProductEntity getProductById(String productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    public ProductEntity getProductByName(String productName) {
        return productRepository.findProductByName(productName).orElseThrow(
                () -> new RuntimeException("Product not found with name: " + productName)
        );
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity updateProduct(String id, ProductEntity updatedProduct) {
        ProductEntity existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setStock(updatedProduct.getStock());
        existing.setDescription(updatedProduct.getDescription());
        return productRepository.save(existing);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
