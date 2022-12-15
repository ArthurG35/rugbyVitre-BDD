package com.arthur.fr.rugbyvitre.exceptions.userExceptions;

public class LoginIdentifierException extends RuntimeException{
    public LoginIdentifierException(String msg){
        super(msg);
    }

    public LoginIdentifierException(){
        super("No user found for the given user/password");
    }
}
