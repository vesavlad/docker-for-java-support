package com.warptronics.docker4j.domain.repo;

import com.warptronics.docker4j.domain.data.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, Integer> {
}
