package com.vodafone.springexceptionhandling.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private  String message;

    public EntityNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
