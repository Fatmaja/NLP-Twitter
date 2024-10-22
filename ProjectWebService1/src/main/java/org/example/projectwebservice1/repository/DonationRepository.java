package com.example.apiproject.repository;

import com.example.apiproject.entity.Animal;
import com.example.apiproject.entity.Donation;
import com.example.apiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    List<Donation> findDonationsByUser(User user);

    List<Donation> findDonationsByAnimal(Animal animal);
}
