package com.jobportal.exception;

public class InvalidLoginException  extends Exception{
    public InvalidLoginException(String message){
        super(message);
    }
}

class DuplicateApplicationException extends Exception{
    public DuplicateApplicationException(String message){
        super(message);
    }
}

class UnauthorizedAccessException  extends  Exception{
    public UnauthorizedAccessException(String message){
        super(message);
    }
}

class ResourceNotFoundException  extends Exception{
    public ResourceNotFoundException(String message){
        super(message);
    }
}