package com.example.homework27.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super();
    }
}
