package com.vodafone.springexceptionhandling.exceptions;

public class UserListEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private  String message;

    public UserListEmptyException(String message){
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
