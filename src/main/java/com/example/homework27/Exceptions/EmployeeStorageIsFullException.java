package com.example.homework27.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
        super();
    }
}
