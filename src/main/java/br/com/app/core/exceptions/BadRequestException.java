package br.com.app.core.exceptions;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
