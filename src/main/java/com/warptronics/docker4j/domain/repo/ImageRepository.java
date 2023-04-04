package com.warptronics.docker4j.domain.repo;

import com.warptronics.docker4j.domain.data.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
