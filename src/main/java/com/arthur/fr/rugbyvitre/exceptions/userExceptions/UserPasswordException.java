package com.arthur.fr.rugbyvitre.exceptions.userExceptions;

public class UserPasswordException extends RuntimeException{

    public UserPasswordException(String msg){
        super(msg);
    }
    public UserPasswordException(){
        super("this password is not strong enough");
    }
}
