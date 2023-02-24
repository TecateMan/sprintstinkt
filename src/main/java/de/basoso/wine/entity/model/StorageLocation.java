package de.basoso.wine.entity.model;

import de.basoso.wine.entity.data.Row;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="storagelocation")
public class StorageLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private int col;
    private Row row;

    @ManyToOne
    private Wine wine;
}
