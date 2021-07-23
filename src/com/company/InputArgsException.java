package com.company;

public class InputArgsException extends Exception {
    private String message;

    public InputArgsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
