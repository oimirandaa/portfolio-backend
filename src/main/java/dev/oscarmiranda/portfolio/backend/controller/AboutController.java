package dev.oscarmiranda.portfolio.backend.controller;

import dev.oscarmiranda.portfolio.backend.dto.AboutDTO;
import dev.oscarmiranda.portfolio.backend.service.AboutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/about/")
public class AboutController {
    private AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @PostMapping
    public ResponseEntity<AboutDTO> addAbout(@RequestBody AboutDTO aboutDTO) {
        return new ResponseEntity<>(aboutService.createAbout(aboutDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutDTO> getAboutById(@PathVariable("id") long id) {
        AboutDTO aboutDTO = aboutService.getAboutById(id);

        return ResponseEntity.ok(aboutDTO);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<AboutDTO>> getAllAbout() {
        List<AboutDTO> abouts = aboutService.getAllAbouts();

        return ResponseEntity.ok(abouts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAboutById(@PathVariable("id") long id) {
        aboutService.deleteAboutById(id);
        return ResponseEntity.ok("About Deleted Successfully");
    }
}
