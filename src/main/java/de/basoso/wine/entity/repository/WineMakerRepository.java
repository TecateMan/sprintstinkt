package de.basoso.wine.entity.repository;

import de.basoso.wine.entity.model.WineMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineMakerRepository extends JpaRepository<WineMaker, long> {
}
