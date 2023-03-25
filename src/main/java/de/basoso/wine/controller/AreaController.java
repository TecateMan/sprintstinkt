package de.basoso.wine.controller;

import de.basoso.wine.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/area")
public class AreaController {

    @Autowired
    private AreaService areaService;
}
