package org.example.exceptionHandler;

public class AmountException extends IllegalArgumentException {
    public AmountException() {}
    public AmountException(String message) {}
    public AmountException(String message, Throwable cause) {}
}
