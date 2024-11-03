package dev.oscarmiranda.portfolio.backend.repository;

import dev.oscarmiranda.portfolio.backend.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
