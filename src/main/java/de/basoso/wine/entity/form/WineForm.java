package de.basoso.wine.entity.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WineForm {

    private long wineId;
    private String name;
}
