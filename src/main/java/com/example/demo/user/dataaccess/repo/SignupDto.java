package com.example.demo.user.dataaccess.repo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupDto {

    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;


}
