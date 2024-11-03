package dev.oscarmiranda.portfolio.backend.controller;

import dev.oscarmiranda.portfolio.backend.dto.BrandsDTO;
import dev.oscarmiranda.portfolio.backend.service.BrandsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands/")
public class BrandsController {
    private BrandsService brandsService;

    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @PostMapping
    public ResponseEntity<BrandsDTO> createBrand(@RequestBody BrandsDTO brandsDTO) {
        return new ResponseEntity<>(brandsService.createBrand(brandsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandsDTO> getBrandById(@PathVariable("id") int id) {
        BrandsDTO brandsDTO = brandsService.getBrandById(id);
        return ResponseEntity.ok(brandsDTO);
    }

    @GetMapping("/allBrands")
    public ResponseEntity<List<BrandsDTO>> getAllBrands() {
        List<BrandsDTO> brands = brandsService.getAllBrands();

        return ResponseEntity.ok(brands);
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") int id) {
        brandsService.deleteBrandById(id);
        return ResponseEntity.ok("Brand Deleted Successfully");
    }
}
