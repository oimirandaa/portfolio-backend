package dev.oscarmiranda.portfolio.backend.controller;

import dev.oscarmiranda.portfolio.backend.dto.WorkDTO;
import dev.oscarmiranda.portfolio.backend.service.WorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/work")
@RestController
public class WorkController {
    private WorkService workService;
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping
    public ResponseEntity<WorkDTO> createWork(@RequestBody WorkDTO workDTO) {
        return new ResponseEntity<>(workService.createWork(workDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDTO> getWorkById(@PathVariable long id) {
        WorkDTO workDTO = workService.getContactById(id);

        return ResponseEntity.ok(workDTO);
    }

    @CrossOrigin
    @GetMapping("/allWork")
    public ResponseEntity<List<WorkDTO>> getAllWork() {
        List<WorkDTO> workDTOList = workService.getAllWork();
        return ResponseEntity.ok(workDTOList);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteWork(@PathVariable long id) {
        workService.deleteWork(id);

        return ResponseEntity.ok("Contact Deleted Succesfully");
    }
}
