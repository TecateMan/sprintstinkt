package de.basoso.wine.entity.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WineMakerForm {

    private String name;
    private String domaine;
    private String street;
    private String town;
    private String zip;
}
