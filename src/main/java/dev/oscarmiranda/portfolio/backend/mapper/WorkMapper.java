package dev.oscarmiranda.portfolio.backend.mapper;

import dev.oscarmiranda.portfolio.backend.dto.WorkDTO;
import dev.oscarmiranda.portfolio.backend.entity.Work;

public class WorkMapper {
    public static WorkDTO mapWorkToWorkDTO(Work work){
        return new WorkDTO(
                work.getId(),
                work.getTitle(),
                work.getDescription(),
                work.getProjectLink(),
                work.getCodeLink(),
                work.getImageUrl(),
                work.getTags()
        );
    }

    public static Work mapWorkDTOToWork(WorkDTO workDTO){
        return new Work(
                workDTO.id(),
                workDTO.title(),
                workDTO.description(),
                workDTO.projectLink(),
                workDTO.codeLink(),
                workDTO.imageUrl(),
                workDTO.tags()
        );
    }
}
