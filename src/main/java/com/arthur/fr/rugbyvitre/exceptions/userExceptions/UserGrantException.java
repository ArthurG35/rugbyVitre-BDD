package com.arthur.fr.rugbyvitre.exceptions.userExceptions;

public class UserGrantException extends RuntimeException{
    public UserGrantException(String msg){
        super(msg);
    }

    public UserGrantException(){
        super("Unknown grant");
    }
}
