package com.swlo.distribuitioncenter.business.mapper;

import com.swlo.distribuitioncenter.business.dto.ProductDto;
import com.swlo.distribuitioncenter.entities.ProductEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductEntity toEntity(ProductDto productDto);

    ProductDto toDto(ProductEntity productEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductEntity partialUpdate(ProductDto productDto, @MappingTarget ProductEntity productEntity);
}