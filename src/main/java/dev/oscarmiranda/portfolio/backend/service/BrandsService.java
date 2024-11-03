package dev.oscarmiranda.portfolio.backend.service;

import dev.oscarmiranda.portfolio.backend.dto.BrandsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandsService {
    BrandsDTO getBrandById(long id);
    List<BrandsDTO> getAllBrands();
    void deleteBrandById(long id);
    BrandsDTO createBrand(BrandsDTO brandsDTO);
}
