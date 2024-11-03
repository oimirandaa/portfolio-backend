package dev.oscarmiranda.portfolio.backend.dto;

public record WorkDTO(
        long id,
        String title,
        String description,
        String projectLink,
        String codeLink,
        String imageUrl,
        String tags
) {
}
