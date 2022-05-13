package com.example.demo.appUser.logic.impl.usecase;

import com.example.demo.appUser.dataaccess.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()

public class AppUserService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;


//    public void setUserRepository(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findBYEmail(email).orElseThrow(()->new UsernameNotFoundException(""));
    }
}
