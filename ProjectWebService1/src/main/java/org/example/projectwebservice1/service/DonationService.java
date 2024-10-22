package org.example.projectwebservice1.service;

import com.example.apiproject.entity.Animal;
import com.example.apiproject.entity.Donation;
import com.example.apiproject.entity.User;
import com.example.apiproject.exceptions.ResourceNotFoundException;
import com.example.apiproject.repository.AnimalRepository;
import com.example.apiproject.repository.DonationRepository;
import com.example.apiproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    private final AnimalRepository animalRepository;

    public Donation create(Donation donation, String token) {
        var user = userService.findUserByToken(token);
        donation.setUser(user);
        return donationRepository.save(donation);
    }

    public List<Donation> showAll(){
        return donationRepository.findAll();
    }

    public Donation showDetails(Integer id){
        return donationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This donation doesn't exist"+id));
    }

    public List<Donation> showDonationsPerAnimal(Integer id){
        Animal animal = animalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This Animal doesn't exist"+id));
        return donationRepository.findDonationsByAnimal(animal);
    }
    public List<Donation> showAllUserDonations(Integer id){
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This User doesn't exist"+id));
        return donationRepository.findDonationsByUser(user);
    }
}
