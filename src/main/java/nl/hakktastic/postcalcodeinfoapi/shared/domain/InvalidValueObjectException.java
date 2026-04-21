package nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject;

public class InvalidValueObjectException extends RuntimeException {

    public InvalidValueObjectException(String message) {
        super(message);
    }
}