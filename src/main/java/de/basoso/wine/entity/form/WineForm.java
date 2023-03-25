package de.basoso.wine.entity.form;

import de.basoso.wine.entity.data.BottleType;
import de.basoso.wine.entity.data.Country;
import de.basoso.wine.entity.data.Type;
import de.basoso.wine.entity.model.Area;
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
    private Country country;
    private Area area;
    private Type type;
}
