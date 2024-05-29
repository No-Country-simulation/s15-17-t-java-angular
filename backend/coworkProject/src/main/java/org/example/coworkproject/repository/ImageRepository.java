package org.example.coworkproject.repository;

import org.example.coworkproject.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

//    List<Image> findByOrderById(String name);
}
