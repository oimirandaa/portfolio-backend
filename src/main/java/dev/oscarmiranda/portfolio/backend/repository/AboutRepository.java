package dev.oscarmiranda.portfolio.backend.repository;

import dev.oscarmiranda.portfolio.backend.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}
