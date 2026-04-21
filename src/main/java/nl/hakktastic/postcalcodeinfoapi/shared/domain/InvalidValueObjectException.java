package nl.hakktastic.postcalcodeinfoapi.shared.domain;

public class InvalidValueObjectException extends RuntimeException {
    public InvalidValueObjectException(String message) {
        super(message);
    }
}