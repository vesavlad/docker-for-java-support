package com.warptronics.docker4j.domain.data;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GenericGenerator(
            name = "image_sequence",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(
                            name = SEQUENCE_PARAM,
                            value = "image_seq"
                    ),
                    @Parameter(
                            name = INCREMENT_PARAM,
                            value = "1"
                    )
            }
    )
    @GeneratedValue(generator = "image_sequence", strategy = GenerationType.SEQUENCE)
    private final Integer id;

    @Column(name = "image_name")
    private final String name;

    public Image(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Image() {
        // required by JPA
        this.id = null;
        this.name = null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!getId().equals(image.getId())) return false;
        return getName().equals(image.getName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
