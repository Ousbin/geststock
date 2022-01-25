package com.ousmane.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException  extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message){
        super(message);
    }

    public InvalidEntityException(String message,Throwable cause){
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes){
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCodes){
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors){
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
