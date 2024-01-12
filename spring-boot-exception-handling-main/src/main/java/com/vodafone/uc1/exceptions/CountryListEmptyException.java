package com.vodafone.uc1.exceptions;

public class CountryListEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private  String message;

    public CountryListEmptyException(String message){
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