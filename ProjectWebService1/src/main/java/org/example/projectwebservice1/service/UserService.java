package org.example.projectwebservice1.service;

import com.example.apiproject.config.JwtService;
import com.example.apiproject.entity.User;
import com.example.apiproject.exceptions.UserNotFoundException;
import com.example.apiproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public User findUserByToken(String token) {
        String userEmail = extractUserEmailFromToken(token);
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(userEmail));
    }


    private String extractUserEmailFromToken(String token) {
        return jwtService.extractUsername(token.substring(7));
    }
}
