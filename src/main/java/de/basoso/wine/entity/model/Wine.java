package de.basoso.wine.entity.model;

import de.basoso.wine.entity.data.BottleType;
import de.basoso.wine.entity.data.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


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
    private String winemaker;
    private float price;
    private Date dayOfPurchase;
    private int number;

    private BottleType bottle;
    private Type type;


}
