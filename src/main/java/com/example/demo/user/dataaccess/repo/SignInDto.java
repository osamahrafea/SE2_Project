package com.example.demo.user.dataaccess.repo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInDto {
    private String email;
    private String password;
}
