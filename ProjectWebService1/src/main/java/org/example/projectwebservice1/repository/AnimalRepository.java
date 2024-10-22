package com.example.apiproject.repository;

import com.example.apiproject.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {
}
