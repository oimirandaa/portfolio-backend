package dev.oscarmiranda.portfolio.backend.service.impl;

import dev.oscarmiranda.portfolio.backend.dto.BrandsDTO;
import dev.oscarmiranda.portfolio.backend.entity.Brands;
import dev.oscarmiranda.portfolio.backend.mapper.BrandsMapper;
import dev.oscarmiranda.portfolio.backend.repository.BrandsRepository;
import dev.oscarmiranda.portfolio.backend.service.BrandsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandsServiceImpl implements BrandsService {
    private BrandsRepository brandsRepository;

    public BrandsServiceImpl(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    @Override
    public BrandsDTO getBrandById(long id) {
        Brands brands = brandsRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No Brand found by id: " + id));

        return BrandsMapper.brandsToBrandsDTO(brands);
    }

    @Override
    public List<BrandsDTO> getAllBrands() {
        List<Brands> brands = brandsRepository.findAll();
        return brands.stream()
                .map(BrandsMapper::brandsToBrandsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBrandById(long id) {
        brandsRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No Brand found by id: " + id));
        brandsRepository.deleteById(id);
    }

    @Override
    public BrandsDTO createBrand(BrandsDTO brandsDTO) {
        Brands brands = BrandsMapper.brandDTOToBrands(brandsDTO);
        Brands savedBrand = brandsRepository.save(brands);
        return BrandsMapper.brandsToBrandsDTO(savedBrand);
    }
}
