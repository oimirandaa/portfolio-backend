package dev.oscarmiranda.portfolio.backend.mapper;

import dev.oscarmiranda.portfolio.backend.dto.BrandsDTO;
import dev.oscarmiranda.portfolio.backend.entity.Brands;

public class BrandsMapper {
    public static Brands brandDTOToBrands(BrandsDTO brandsDTO) {
        return new Brands(
                brandsDTO.id(),
                brandsDTO.name(),
                brandsDTO.imageURL()
        );
    }
    public static BrandsDTO brandsToBrandsDTO(Brands brands) {
        return new BrandsDTO(
                brands.getId(),
                brands.getName(),
                brands.getImageURL()
        );
    }
}
