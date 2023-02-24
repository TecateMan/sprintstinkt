package de.basoso.wine.controller;

import de.basoso.wine.entity.form.WineMakerForm;
import de.basoso.wine.entity.model.Wine;
import de.basoso.wine.entity.model.WineMaker;
import de.basoso.wine.service.WineMakerService;
import de.basoso.wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "winemaker")
public class WineMakerController {

    @Autowired
    WineMakerService wineMakerService;

    @Autowired
    WineService wineService;

    @PostMapping
    public ResponseEntity<WineMaker> createWineMaker(WineMakerForm wineMakerForm) {
        return ResponseEntity.ok(wineMakerService.createWineMaker(wineMakerForm));
    }

    @PutMapping
    public ResponseEntity<WineMaker> updateWineMakerResponseEntity(WineMakerForm wineMakerForm ){
        return ResponseEntity.ok(wineMakerService.updateWineMaker(wineMakerForm));
    }

    @GetMapping
    public ResponseEntity<WineMaker> getWineMaker(@PathVariable("id") long id){
        Optional<WineMaker> optWineMaker = wineMakerService.findById(id);
        return optWineMaker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
