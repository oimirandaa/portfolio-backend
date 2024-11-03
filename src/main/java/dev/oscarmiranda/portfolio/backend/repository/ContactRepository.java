package dev.oscarmiranda.portfolio.backend.repository;

import dev.oscarmiranda.portfolio.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
