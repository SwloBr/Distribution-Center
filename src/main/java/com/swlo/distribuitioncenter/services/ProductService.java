package com.swlo.distribuitioncenter.services;

import com.swlo.distribuitioncenter.business.clients.CdClient;
import com.swlo.distribuitioncenter.business.clients.HubClient;
import com.swlo.distribuitioncenter.business.dto.CreateProductDto;
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

    public ProductEntity updateProduct(String id, CreateProductDto dto) {

        ProductEntity existing;
        try {
            existing = getProductById(id);
            existing.setName(dto.name());
            existing.setPrice(dto.price());
            existing.setStock(dto.stock());
            existing.setDescription(dto.description());
        }
        catch (RuntimeException e) {
            existing = createProduct(dto);
        }

        return productRepository.save(existing);
    }


    public ProductEntity createProduct(CreateProductDto dto) {

        String productId = hubClient.getProductId(dto.name());

        ProductEntity product = new ProductEntity(
                productId,
                dto.name(),
                dto.price(),
                dto.stock(),
                dto.description()
        );

        return productRepository.save(product);
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


    public void sendProduct(String productId, int quantity) {
        ProductEntity product = getProductByName(productId);
        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + productId);
        }
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }

    public ProductEntity takeProduct(String productName, int quantity, String cdUrl) {
        ProductEntity product = getProductByName(productName);
        if (product == null) {
            throw new RuntimeException("Product not found with id: " + productName);
        }
        CdClient cdClient = new CdClient(cdUrl);
        try {
            cdClient.sendProduct(productName, quantity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send product to CD: " + e.getMessage());
        }
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }
}
