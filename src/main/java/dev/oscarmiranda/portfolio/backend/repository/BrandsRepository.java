package dev.oscarmiranda.portfolio.backend.repository;

import dev.oscarmiranda.portfolio.backend.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brands, Long> {
}
