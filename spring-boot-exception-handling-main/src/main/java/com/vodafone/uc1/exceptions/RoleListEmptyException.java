package com.vodafone.uc1.exceptions;

public class RoleListEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private  String message;

    public RoleListEmptyException(String message){
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
