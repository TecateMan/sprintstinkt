package de.basoso.wine.entity.form;

import de.basoso.wine.entity.data.BottleType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WineForm {

    private long id;
    private String name;
    private int year;
    private String winemaker;
    private float price;
    private Date dayOfPurchase;
    private int number;
    private BottleType bottle;
}
