package de.basoso.wine.service;

import de.basoso.wine.entity.form.WineForm;
import de.basoso.wine.entity.form.WineMakerForm;
import de.basoso.wine.entity.model.Wine;
import de.basoso.wine.entity.model.WineMaker;
import de.basoso.wine.entity.repository.WineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WineService {

    @Autowired
   private WineRepository wineRepository;

    private WineMakerService wineMakerService;

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
        // TODO Logik für Update einbauen

        return wineRepository.save(w);
    }

    public void deleteWine(String name) {
        Optional<Wine> optionalWine = findByName(name);

        if(!optionalWine.isPresent()){
            throw new ResourceNotFoundException("Wine not found!");
        }
        Wine w = optionalWine.get();
        wineRepository.deleteById(w.getId());
    }

    public Optional<Wine> findById(Long id) {
        return wineRepository.findById(id);
    }

    public Optional<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }

    public List<Wine> findWinesByWinemaker(WineMakerForm wineMakerForm) {
        Optional<WineMaker> optionalWineMaker = wineMakerService.findByName(wineMakerForm.getName());
        if(!optionalWineMaker.isPresent()){
            throw new ResourceNotFoundException("Winemaker not found!");
        }
        WineMaker w = optionalWineMaker.get();
        List<Wine> listOfWines = wineRepository.findWinesByWineMaker(w.getName());

        return listOfWines;
    }

    public List<Wine> findAllWines() {
        return wineRepository.findAll();
    }
}
