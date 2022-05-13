package com.example.demo.appUser;

import com.example.demo.appUser.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

//    @Autowired
    private final UserRepository userRepository;


//    public void setUserRepository(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findBYEmail(email).orElseThrow(()->new UsernameNotFoundException(""));
    }
}
