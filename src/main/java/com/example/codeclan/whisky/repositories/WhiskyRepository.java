package com.example.codeclan.whisky.repositories;

import com.example.codeclan.whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}
