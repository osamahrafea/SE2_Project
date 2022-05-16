package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Status registerUser( @RequestBody SignupDto signupDto) {

        userService.signUp(signupDto);
        return Status.SUCCESS;
    }
    @PostMapping("/login")
    public SignInResponseDte loginUser( @RequestBody SignInDto signinDto) {
        return userService.signIn(signinDto);
    }
//    @PostMapping("/users/logout")
//    public Status logUserOut( @RequestBody User user) {
//        List<User> users = userRepository.findAll();
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(false);
//                userRepository.save(user);
//                return Status.SUCCESS;
//            }
//        }
//        return Status.FAILURE;
//    }
//    @DeleteMapping("/users/all")
//    public Status deleteUsers() {
//        userRepository.deleteAll();
//        return Status.SUCCESS;
//    }
}