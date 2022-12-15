package com.arthur.fr.rugbyvitre.exceptions;

public class NotAllowedToCreateException extends RuntimeException{

    public NotAllowedToCreateException(String msg){
        super(msg);
    }

    public NotAllowedToCreateException(){
        super("Given id is already known");
    }
}
