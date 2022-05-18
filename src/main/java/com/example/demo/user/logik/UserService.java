package com.example.demo.user.logik;

import com.example.demo.user.dataaccess.repo.*;
import com.example.demo.user.exceptions.AuthenticationFailException;
import com.example.demo.user.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    /*
    check if the user is already exist
    * Sign up the User in the Datebase
    * Create Token
    * Encode the Password
    * */
    @Transactional
    public Status signUp(SignupDto signupDto) {
        //check if user already there
        if (userRepository.findUserByEmail(signupDto.getEmail()).isPresent()) {
            //we have the user
            throw new CustomException("User already exist");
        }
        ;
        //encode password
        String encodedPassword = signupDto.getPassword();
        try {
            encodedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // save user
        User user =new User();
        user.setEmail(signupDto.getEmail());
        user.setPassword(encodedPassword);
        user.setUsername(signupDto.getUsername());
        user.setFirstname(signupDto.getFirstname());
        user.setLastname(signupDto.getLastname());
        user.setPhone(signupDto.getPhone());
        userRepository.save(user);

        // create the Token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);

        return Status.SUCCESS;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDte signIn(SignInDto signinDto) {
        //find User by Email
        Optional<User> user=userRepository.findUserByEmail(signinDto.getEmail());
       if (!user.isPresent()){

        throw new AuthenticationFailException("user is not valid");

       }
        try {
            if(!user.get().getPassword().equals(hashPassword(signinDto.getPassword()))){
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Optional<AuthenticationToken> token=authenticationService.getToken(user.get());
        if(!token.isPresent()){

            throw new CustomException("Token is not Present");
        }
        return new SignInResponseDte("sucess",token.get().getToken());
    }
}
