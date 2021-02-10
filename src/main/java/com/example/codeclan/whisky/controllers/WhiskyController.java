package com.example.codeclan.whisky.controllers;

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

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "distilleryName", required = false) String distilleryName,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "regionName", required = false) String regionName
    ) {
        if (distilleryName != null && age != null) {
            List<Whisky> whiskyByDistilleryAndAge = whiskyRepository.findByDistilleryNameIgnoreCaseAndAge(distilleryName, age);
            return new ResponseEntity<>(whiskyByDistilleryAndAge, HttpStatus.OK);
        }
        if (year != null) {
            List<Whisky> whiskyByYear = whiskyRepository.findByYear(year);
            return new ResponseEntity<>(whiskyByYear, HttpStatus.OK);
        }
        if (distilleryName !=null) {
            List<Whisky> whiskyByDistillery = whiskyRepository.findByDistilleryNameIgnoreCase(distilleryName);
            return new ResponseEntity<>(whiskyByDistillery, HttpStatus.OK);
        }
        if (regionName != null) {
            List<Whisky> whiskyByRegion = whiskyRepository.findByDistilleryRegionIgnoreCase(regionName);
            return new ResponseEntity<>(whiskyByRegion, HttpStatus.OK);
        }
        if (age != null) {
            List<Whisky> whiskyByAge = whiskyRepository.findByAge(age);
            return new ResponseEntity<>(whiskyByAge, HttpStatus.OK);
        }
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhisky(@PathVariable Long id) {
        Optional<Whisky> whisky = whiskyRepository.findById(id);
        return new ResponseEntity<>(whisky, HttpStatus.OK);
    }

}
