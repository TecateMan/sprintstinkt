package de.basoso.wine.controller;

import de.basoso.wine.entity.form.WineForm;
import de.basoso.wine.entity.form.WineMakerForm;
import de.basoso.wine.entity.model.Wine;
import de.basoso.wine.service.WineMakerService;
import de.basoso.wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "wine")
public class WineController {

    @Autowired
    private WineService wineService;

    @Autowired
    WineMakerService wineMakerService;

    @PostMapping
    public ResponseEntity<Wine> createWine(@RequestBody WineForm wineForm){
        return ResponseEntity.ok(wineService.createWine(wineForm));
    }

    @PutMapping
    public ResponseEntity<Wine> updateWine(@RequestBody WineForm wineForm) {
        return ResponseEntity.ok(wineService.updateWine(wineForm));
    }

    @GetMapping
    public ResponseEntity<Wine> getWine(@PathVariable("id") long id){
        Optional<Wine> optWine = wineService.findById(id);
        return optWine.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   @GetMapping(path = "/winebymaker")
    public ResponseEntity<List<Wine>> getWinesByWinemaker(@RequestBody WineMakerForm wineMakerForm) {
        return ResponseEntity.ok(wineService.findWinesByWinemaker(wineMakerForm));
    }

    @GetMapping(path = "/wines")
    public ResponseEntity<List<Wine>> getAllWines() {
        return ResponseEntity.ok(wineService.findAllWines());
    }

    @DeleteMapping
    public void deleteWine(WineForm wineForm) {
        wineService.deleteWine(wineForm.getName());
    }
}
