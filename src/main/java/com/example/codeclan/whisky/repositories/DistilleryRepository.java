package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
