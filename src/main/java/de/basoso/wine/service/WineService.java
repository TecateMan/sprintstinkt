package de.basoso.wine.service;

import de.basoso.wine.entity.form.WineForm;
import de.basoso.wine.entity.model.Wine;
import de.basoso.wine.entity.repository.WineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WineService {

    @Autowired
   private WineRepository wineRepository;

    public Wine createWine(WineForm wineForm) {

        Wine w = Wine
                .builder()
                .name(wineForm.getName())
                .build();
        return wineRepository.save(w);
    }

    public Wine updateWine(WineForm wineForm){
        Optional<Wine> optWine = findByName(wineForm.getName());
        if(!optWine.isPresent()){
            throw new ResourceNotFoundException("Wine not found!");
        }
        Wine w = optWine.get();
        return wineRepository.save(w);
    }

    public Optional<Wine> findById(Long id) {
        return wineRepository.findById(id);
    }

    public Optional<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }
}
