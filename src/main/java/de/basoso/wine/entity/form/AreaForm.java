package de.basoso.wine.entity.form;

import de.basoso.wine.entity.data.Country;
import de.basoso.wine.entity.model.Wine;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AreaForm {
    private long id;
    private String name;
    private Country country;
    @OneToMany
     private List<Wine> wines;
}
