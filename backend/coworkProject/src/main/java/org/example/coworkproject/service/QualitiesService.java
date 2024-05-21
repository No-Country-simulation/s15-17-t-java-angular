package org.example.coworkproject.service;

import org.example.coworkproject.entity.QualitiesEntity;
import org.example.coworkproject.repository.QualitiesRepository;
import org.springframework.stereotype.Service;

@Service
public class QualitiesService {
    private final QualitiesRepository qualitiesRepository;

    public QualitiesService(QualitiesRepository qualitiesRepository) {
        this.qualitiesRepository = qualitiesRepository;
    }

    public QualitiesEntity create(QualitiesEntity body){
        return qualitiesRepository.save(body);
    }

}
