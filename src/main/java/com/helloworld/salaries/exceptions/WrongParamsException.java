package com.helloworld.salaries.exceptions;

public class WrongParamsException extends Exception{

    private String field;

    public WrongParamsException(String field){
        super("The field " + field + " is wrong");
        this.field = field;
    }
}
