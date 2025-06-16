package com.swlo.distribuitioncenter.repositories;

import com.swlo.distribuitioncenter.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {

    Optional<ProductEntity> findProductByName(String productName);


}
