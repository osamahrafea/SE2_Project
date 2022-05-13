package com.example.demo.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String laasName;
    private final String email;
    private final String passWord;

}
