package com.ousmane.gestiondestock.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message,Throwable cause){
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes){
        super(message);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCodes){
        super(message);
        this.errorCode = errorCode;
    }
}
