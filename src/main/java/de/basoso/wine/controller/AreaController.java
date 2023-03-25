package de.basoso.wine.controller;

import de.basoso.wine.entity.form.AreaForm;
import de.basoso.wine.entity.model.Area;
import de.basoso.wine.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody AreaForm areaForm) {
        return ResponseEntity.ok(areaService.createArea(areaForm));
    }

    @PutMapping
    public ResponseEntity<Area> updateArea(@RequestBody AreaForm areaForm) {
        return ResponseEntity.ok(areaService.updateArea(areaForm));
    }

    @GetMapping
    public ResponseEntity<Area> getArea(@PathVariable("name") String name) {
        Optional<Area> optionalArea = areaService.findbyName(name);
        return optionalArea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
