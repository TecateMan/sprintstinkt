package de.basoso.wine.service;

import de.basoso.wine.entity.form.AreaForm;
import de.basoso.wine.entity.model.Area;
import de.basoso.wine.entity.repository.AreaRepository;
import de.basoso.wine.exceptions.ResourceAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Transactional
    public Area createArea(AreaForm areaForm) {
        Optional<Area> optionalArea = findbyName(areaForm.getName());
        if(optionalArea.isPresent()){
            throw new ResourceAlreadyExistsException("Area already exits!");
        }
        Area a = Area
                .builder()
                .name(areaForm.getName())
                .country(areaForm.getCountry())
                .build();
        return areaRepository.save(a);
    }

    public Optional<Area> findbyName(String name){
        return areaRepository.findByName(name);
    }

    @Transactional
    public Area updateArea(AreaForm areaForm) {
        Optional<Area> optionalArea = findbyName(areaForm.getName());
        if(!optionalArea.isPresent()){
            throw new ResourceNotFoundException("Area not found!");
        }
        Area a = optionalArea.get();
        return areaRepository.save(a);
    }


}

