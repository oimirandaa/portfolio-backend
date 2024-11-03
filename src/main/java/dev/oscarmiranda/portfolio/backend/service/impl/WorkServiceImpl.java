package dev.oscarmiranda.portfolio.backend.service.impl;

import dev.oscarmiranda.portfolio.backend.dto.WorkDTO;
import dev.oscarmiranda.portfolio.backend.entity.Work;
import dev.oscarmiranda.portfolio.backend.mapper.WorkMapper;
import dev.oscarmiranda.portfolio.backend.repository.WorkRepository;
import dev.oscarmiranda.portfolio.backend.service.WorkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkServiceImpl implements WorkService {
    private WorkRepository workRepository;

    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public WorkDTO createWork(WorkDTO workDTO) {
        Work work = WorkMapper.mapWorkDTOToWork(workDTO);
        Work savedWork = workRepository.save(work);

        return WorkMapper.mapWorkToWorkDTO(savedWork);
    }

    @Override
    public WorkDTO getContactById(long id) {
        Work work = workRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el trabajo"));

        return WorkMapper.mapWorkToWorkDTO(work);
    }

    @Override
    public List<WorkDTO> getAllWork() {
        List<Work> works = workRepository.findAll();
        return works.stream()
                .map(WorkMapper::mapWorkToWorkDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteWork(long id) {
        workRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el trabajo"));
        workRepository.deleteById(id);
    }
}
