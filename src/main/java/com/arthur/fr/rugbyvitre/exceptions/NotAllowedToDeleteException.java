package com.arthur.fr.rugbyvitre.exceptions;

public class NotAllowedToDeleteException extends RuntimeException{

    public NotAllowedToDeleteException(String message) {
        super(message);
    }

    public NotAllowedToDeleteException() {
        super("Cannot delete the given element.");
    }
}
