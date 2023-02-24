package de.basoso.wine.service;

import de.basoso.wine.entity.form.WineMakerForm;
import de.basoso.wine.entity.model.WineMaker;
import de.basoso.wine.entity.repository.WineMakerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WineMakerService {
    @Autowired
    private WineMakerRepository wineMakerRepository;

    public WineMaker createWineMaker(WineMakerForm wineMakerForm) {
        WineMaker w = WineMaker
                .builder()
                .name(wineMakerForm.getName())
                .domaine(wineMakerForm.getDomaine())
                .street(wineMakerForm.getStreet())
                .town(wineMakerForm.getTown())
                .zip((wineMakerForm.getZip()))
                .build();
        return wineMakerRepository.save(w);
    }

    public WineMaker updateWineMaker(WineMakerForm wineMakerForm) {
        Optional<WineMaker> optionalWineMaker = findByName(wineMakerForm.getName());
        if(!optionalWineMaker.isPresent()) {
            throw new ResourceNotFoundException("Winemaker not found!");
        }
        WineMaker w = optionalWineMaker.get();
        // TODO Logik fuer Update einbauen

        return wineMakerRepository.save(w);
    }

    public Optional<WineMaker> findByName(String name) { return wineMakerRepository.findByName(name);}

    public Optional<WineMaker> findById(long id) { return wineMakerRepository.findById(id);}
}
