package com.warptronics.docker4j.domain.data;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import static org.hibernate.id.OptimizableGenerator.INCREMENT_PARAM;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM;

@Entity
@Table(name = "container")
public class Container {

    @Id
    @GenericGenerator(
            name = "container_sequence",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(
                            name = SEQUENCE_PARAM,
                            value = "container_seq"
                    ),
                    @Parameter(
                            name = INCREMENT_PARAM,
                            value = "1"
                    )
            }
    )
    @GeneratedValue(generator = "container_sequence")
    private final Integer id;

    @Column(name = "container_name")
    private final String name;

    @ManyToOne(
            targetEntity = Image.class
    )
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private final Image image;

    public Container(int id, String name, Image image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    protected Container() {
        // required by JPA
        this.id = null;
        this.name = null;
        this.image = null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (!getId().equals(container.getId())) return false;
        if (!getName().equals(container.getName())) return false;
        return getImage().equals(container.getImage());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getImage().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
