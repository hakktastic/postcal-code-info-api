package nl.hakktastic.postcalcodeinfoapi.shared.domain;

public class PostalCodeInformationAlreadyExistsException extends RuntimeException {
    public PostalCodeInformationAlreadyExistsException(String message) {
        super(message);
    }
}