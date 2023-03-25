package de.basoso.wine.service;

import de.basoso.wine.entity.repository.AreaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;
}
