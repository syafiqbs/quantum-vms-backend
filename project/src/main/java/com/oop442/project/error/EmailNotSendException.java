package com.oop442.project.error;

public class EmailNotSendException extends RuntimeException{

    public EmailNotSendException(String message) {
        super("Error sending email to recipient: " + message);
    }
    
}
