package nl.hakktastic.postcalcodeinfoapi.shared.domain;

public class PostalCodeInformationNotFoundException extends RuntimeException {
    public PostalCodeInformationNotFoundException(String message) {
        super(message);
    }
}