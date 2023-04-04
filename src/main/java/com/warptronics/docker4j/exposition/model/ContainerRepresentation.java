package com.warptronics.docker4j.exposition.model;

import com.warptronics.docker4j.domain.data.Container;

public record ContainerRepresentation(int id, String name, int imageId) {

    public ContainerRepresentation(Container container) {
        this(container.getId(), container.getName(), container.getImage().getId());
    }
}
