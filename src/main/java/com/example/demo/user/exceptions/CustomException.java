package com.example.demo.user.exceptions;

public class CustomException extends IllegalArgumentException {
    public CustomException(String msg)
    {
       super(msg);
    }
}
