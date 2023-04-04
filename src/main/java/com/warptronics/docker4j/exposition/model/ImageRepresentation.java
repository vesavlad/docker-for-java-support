package com.warptronics.docker4j.exposition.model;

import com.warptronics.docker4j.domain.data.Image;

public record ImageRepresentation(int id, String name) {

    public ImageRepresentation(Image image) {
        this(image.getId(), image.getName());
    }
}
