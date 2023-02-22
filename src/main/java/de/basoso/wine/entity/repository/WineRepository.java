package de.basoso.wine.entity.repository;

import de.basoso.wine.entity.model.Wine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WineRepository extends CrudRepository<Wine, Long> {

    Optional<Wine> findByName(@Param("name") String name);
}
