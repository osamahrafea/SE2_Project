package com.example.demo.registration;

import com.example.demo.appUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public static String register(RegistrationRequest request) {
        return "works";
    }
}
