package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    // get all whiskies from a particular year
    List<Whisky> findByYear(int year);
    // get all whiskies from a particular distillery
    List<Whisky> findByDistilleryNameIgnoreCase(String name);
    // get all whiskies of a certain age
    List<Whisky> findByAge(int age);
    // get all whiskies from specific distillery + of a certain age
    List<Whisky> findByDistilleryNameIgnoreCaseAndAge(String distilleryName, int age);
}

