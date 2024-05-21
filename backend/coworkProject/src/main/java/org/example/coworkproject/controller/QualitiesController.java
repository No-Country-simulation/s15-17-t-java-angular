package org.example.coworkproject.controller;

import org.example.coworkproject.entity.QualitiesEntity;
import org.example.coworkproject.service.QualitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/qualities")
public class QualitiesController {
    @Autowired
    private QualitiesService qualitiesService;

    @PostMapping
    public ResponseEntity<QualitiesEntity> create(@RequestBody QualitiesEntity body) {
        QualitiesEntity quality = qualitiesService.create(body);
        return ResponseEntity.ok(quality);
    }
}
