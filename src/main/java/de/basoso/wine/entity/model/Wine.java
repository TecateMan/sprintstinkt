package de.basoso.wine.entity.model;

import de.basoso.wine.entity.data.BottleType;
import de.basoso.wine.entity.data.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int year;
    private float price;
    private Date dayOfPurchase;
    private int number;
    private BottleType bottle;
    private Type type;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    private List<Variety> varieties = new ArrayList<>();
    @ManyToOne
    private Area area;
    @OneToMany
    private List<StorageLocation> locations = new ArrayList<>();

    @ManyToOne
    private WineMaker wineMaker;

}
