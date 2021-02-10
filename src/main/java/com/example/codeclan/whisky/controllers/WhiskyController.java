package com.example.codeclan.whisky.controllers;

import com.example.codeclan.whisky.models.Whisky;
import com.example.codeclan.whisky.repositories.DistilleryRepository;
import com.example.codeclan.whisky.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Whisky>> getAllWhiskies() {
        List<Whisky> allWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<>(allWhiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhisky(Long whiskyId) {
        return new ResponseEntity<>(whiskyRepository.findById(whiskyId), HttpStatus.OK);
    }
}
