package dev.oscarmiranda.portfolio.backend.service;

import dev.oscarmiranda.portfolio.backend.dto.AboutDTO;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface AboutService {
    AboutDTO createAbout(AboutDTO aboutDTO);

    AboutDTO getAboutById(long id);

    void deleteAboutById(long id);

    List<AboutDTO> getAllAbouts();
}
