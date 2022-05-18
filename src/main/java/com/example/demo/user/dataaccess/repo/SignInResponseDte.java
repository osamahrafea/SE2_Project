package com.example.demo.user.dataaccess.repo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInResponseDte {
    private String Status;
    private String token;

}
