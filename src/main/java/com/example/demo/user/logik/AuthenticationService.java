package com.example.demo.user.logik;

import com.example.demo.user.dataaccess.repo.AuthenticationToken;
import com.example.demo.user.dataaccess.repo.User;
import com.example.demo.user.dataaccess.repo.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private TokenRepository tokenRepository;
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public Optional<AuthenticationToken> getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
