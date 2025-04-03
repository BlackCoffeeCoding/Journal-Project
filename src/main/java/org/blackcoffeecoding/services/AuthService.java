package org.blackcoffeecoding.services;


import org.blackcoffeecoding.dto.UserRegistrationDto;
import org.blackcoffeecoding.models.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    void register(UserRegistrationDto registrationDTO);

    User getUser(String username);
}
