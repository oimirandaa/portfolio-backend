package dev.oscarmiranda.portfolio.backend.dto;

public record AboutDTO(
        long id,
        String title,
        String description,
        String imageURL
) {
}
