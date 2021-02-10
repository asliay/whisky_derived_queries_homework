package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    // get all whiskies from a particular year
    List<Whisky> findByYear(int year);
}
