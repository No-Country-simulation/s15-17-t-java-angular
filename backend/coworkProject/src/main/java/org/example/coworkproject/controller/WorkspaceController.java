package org.example.coworkproject.controller;

import org.example.coworkproject.entity.WorkspaceEntity;
import org.example.coworkproject.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<WorkspaceEntity> create(@RequestBody WorkspaceEntity body) {
        WorkspaceEntity workspace = workspaceService.create(body);
        return ResponseEntity.ok(workspace);
    }

}
