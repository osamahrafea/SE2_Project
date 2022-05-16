package com.example.demo.user.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String msg)
    {
        super(msg);
    }


}
