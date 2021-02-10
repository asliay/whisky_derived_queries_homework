package com.example.codeclan.whisky.controllers;

import com.example.codeclan.whisky.models.Distillery;
import com.example.codeclan.whisky.models.Whisky;
import com.example.codeclan.whisky.repositories.DistilleryRepository;
import com.example.codeclan.whisky.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    // GET /distilleries
    // GET /distillers?region=Highland          findByRegion
    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name = "region", required = false) String regionName
    ) {
        if (regionName != null) {
            List<Distillery> distilleryByRegion = distilleryRepository.findByRegionIgnoreCase(regionName);
            return new ResponseEntity<>(distilleryByRegion, HttpStatus.OK);
        }
        {
            List<Distillery> allDistilleries = distilleryRepository.findAll();
            return new ResponseEntity<>(allDistilleries, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistillery(@PathVariable Long id) {
        Optional<Distillery> distillery = distilleryRepository.findById(id);
        return new ResponseEntity<>(distillery, HttpStatus.OK);
    }

    //GET whiskies from specific distillery
    @GetMapping(value = "/distilleries/{id}/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskiesFromDistilleryId(@PathVariable Long id) {
        List<Whisky> whiskies = whiskyRepository.findByDistilleryId(id);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

}
