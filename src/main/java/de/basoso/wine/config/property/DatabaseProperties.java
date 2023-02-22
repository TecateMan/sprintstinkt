package de.basoso.wine.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("db")
@Getter
@Setter
public class DatabaseProperties {

    private String url = "jdbc:postgresql://localhost:5432/michaeleimer";
    private String user = "michaeleimer";
    private String password = "";
}
