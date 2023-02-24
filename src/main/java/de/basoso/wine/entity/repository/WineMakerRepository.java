package de.basoso.wine.entity.repository;

import de.basoso.wine.entity.model.WineMaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WineMakerRepository extends CrudRepository<WineMaker, Long> {
    Optional<WineMaker> findByName(@Param("name") String name);
}
