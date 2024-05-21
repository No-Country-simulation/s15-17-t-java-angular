package org.example.coworkproject.service;

import org.example.coworkproject.entity.WorkspaceEntity;
import org.example.coworkproject.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public WorkspaceEntity create(WorkspaceEntity body){
        return workspaceRepository.save(body);
    }

}
