package dev.oscarmiranda.portfolio.backend.dto;

public record ContactDTO(
        long id,
        String name,
        String email,
        String message
) {
}
