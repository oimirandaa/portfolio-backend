package dev.oscarmiranda.portfolio.backend.mapper;

import dev.oscarmiranda.portfolio.backend.dto.AboutDTO;
import dev.oscarmiranda.portfolio.backend.entity.About;

public class AboutMapper {
    public static About mapToAbout(AboutDTO aboutDTO) {
        return new About(
                aboutDTO.id(),
                aboutDTO.title(),
                aboutDTO.description(),
                aboutDTO.imageURL()
        );
    }

    public static AboutDTO mapToAboutDTO(About about) {
        return new AboutDTO(
                about.getId(),
                about.getTitle(),
                about.getDescription(),
                about.getImageURL()
        );
    }
}
