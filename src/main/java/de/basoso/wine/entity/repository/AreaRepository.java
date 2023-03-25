package de.basoso.wine.entity.repository;

import de.basoso.wine.entity.model.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {

    Optional<Area> findByName(@Param("name") String name);

    @Override
    List<Area> findAll();
}
