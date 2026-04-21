package nl.hakktastic.postcalcodeinfoapi.domain.internal;

import org.springframework.modulith.NamedInterface;

@NamedInterface
public class PostalCodeInformationNotFoundException extends RuntimeException {

    public PostalCodeInformationNotFoundException(String message) {
        super(message);
    }
}