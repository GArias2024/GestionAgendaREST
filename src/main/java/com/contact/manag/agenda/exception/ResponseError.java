package com.contact.manag.agenda.exception;

public class ResponseError {
    String error;

    public ResponseError(String error) {
        this.error = error;
    }

    public ResponseError() {

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
