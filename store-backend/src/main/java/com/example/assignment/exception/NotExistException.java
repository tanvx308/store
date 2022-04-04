package com.example.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotExistException extends Exception{
    private Integer code;
    public NotExistException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
