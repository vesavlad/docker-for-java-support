package com.warptronics.docker4j.exposition.controller;

import com.warptronics.docker4j.domain.repo.ContainerRepository;
import com.warptronics.docker4j.domain.repo.ImageRepository;
import com.warptronics.docker4j.exposition.model.ContainerRepresentation;
import com.warptronics.docker4j.exposition.model.ImageRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DockerController {

    private final ImageRepository imageRepository;
    private final ContainerRepository containerRepository;

    @GetMapping("/images")
    public List<ImageRepresentation> getImages() {
        return imageRepository.findAll().stream().map(ImageRepresentation::new).toList();
    }

    @GetMapping("/containers")
    public List<ContainerRepresentation> getContainers() {
        return containerRepository.findAll().stream().map(ContainerRepresentation::new).toList();
    }
}
