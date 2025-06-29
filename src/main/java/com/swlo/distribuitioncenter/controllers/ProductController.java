package com.swlo.distribuitioncenter.controllers;

import com.swlo.distribuitioncenter.business.dto.CreateProductDto;
import com.swlo.distribuitioncenter.business.dto.ProductDto;
import com.swlo.distribuitioncenter.business.dto.TakeProductRequest;
import com.swlo.distribuitioncenter.business.mapper.ProductMapper;
import com.swlo.distribuitioncenter.entities.ProductEntity;
import com.swlo.distribuitioncenter.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto dto) {
        return ResponseEntity.ok(productMapper.toDto(productService.createProduct(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(productMapper.toDto(productService.getProductById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts().stream().map(productMapper::toDto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String id, @RequestBody CreateProductDto dto) {
        return ResponseEntity.ok(productMapper.toDto(productService.updateProduct(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/take")
    public ResponseEntity<ProductDto> takeProduct(@RequestBody TakeProductRequest dto) {
        ProductEntity product = productService.takeProduct(dto.productId(), dto.quantity(), dto.urlCd());
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @GetMapping("/send/{productId}/{quantity}")
    public void sendProduct(@PathVariable String productId, @PathVariable int quantity) {
        productService.sendProduct(productId, quantity);
    }
}
