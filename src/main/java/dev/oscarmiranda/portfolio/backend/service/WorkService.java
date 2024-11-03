package dev.oscarmiranda.portfolio.backend.service;

import dev.oscarmiranda.portfolio.backend.dto.WorkDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkService {
    WorkDTO createWork(WorkDTO workDTO);
    WorkDTO getContactById(long id);
    List<WorkDTO> getAllWork();
    void deleteWork(long id);
}
