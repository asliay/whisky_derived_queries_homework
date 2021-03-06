package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    // get all distilleries for a particular region
    List<Distillery> findByRegionIgnoreCase(String regionName);
    List<Distillery> findByWhiskiesAge(int age);



}
