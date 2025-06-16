package com.swlo.distribuitioncenter.entities;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(nullable = false)
    private Integer stock = 0;

    private String description;

    @PrePersist
    public void prePersist() {
        if (stock == null) {
            stock = 0;
        }
    }



}
