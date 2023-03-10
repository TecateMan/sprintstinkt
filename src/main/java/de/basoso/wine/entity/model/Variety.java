package de.basoso.wine.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class saves information about the actual containing grapes and there percentage.
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="variety")
public class Variety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private float percentage;
    @ManyToMany
    @EqualsAndHashCode.Exclude
    private List<Wine> wines = new ArrayList<>();
}
