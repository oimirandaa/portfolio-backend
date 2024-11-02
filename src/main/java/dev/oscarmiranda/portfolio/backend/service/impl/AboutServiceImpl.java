package dev.oscarmiranda.portfolio.backend.service.impl;

import dev.oscarmiranda.portfolio.backend.dto.AboutDTO;
import dev.oscarmiranda.portfolio.backend.entity.About;
import dev.oscarmiranda.portfolio.backend.mapper.AboutMapper;
import dev.oscarmiranda.portfolio.backend.repository.AboutRepository;
import dev.oscarmiranda.portfolio.backend.service.AboutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutServiceImpl implements AboutService {

    private AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public AboutDTO createAbout(AboutDTO aboutDTO) {
        About aboutObject = AboutMapper.mapToAbout(aboutDTO);
        About savedAbout = aboutRepository.save(aboutObject);
        return AboutMapper.mapToAboutDTO(savedAbout);
    }

    @Override
    public AboutDTO getAboutById(long id) {
        About about = aboutRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No about found with id: " + id));

        return AboutMapper.mapToAboutDTO(about);
    }

    @Override
    public void deleteAboutById(long id) {
        aboutRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No about found with id: " + id));

        aboutRepository.deleteById(id);
    }

    @Override
    public List<AboutDTO> getAllAbouts() {
        List<About> abouts = aboutRepository.findAll();
        return abouts.stream().map(AboutMapper::mapToAboutDTO).collect(Collectors.toList());
    }
}
