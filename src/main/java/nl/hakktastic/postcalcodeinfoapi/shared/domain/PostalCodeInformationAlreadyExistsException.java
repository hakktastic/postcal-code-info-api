package nl.hakktastic.postcalcodeinfoapi.infrastructure.jpa;

public class PostalCodeInformationAlreadyExistsException extends RuntimeException {
    public PostalCodeInformationAlreadyExistsException(String message) {
        super(message);
    }
}