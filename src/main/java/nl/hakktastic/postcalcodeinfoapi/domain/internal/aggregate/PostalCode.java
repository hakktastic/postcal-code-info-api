package nl.hakktastic.postcalcodeinfoapi.domain.internal;

import lombok.RequiredArgsConstructor;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.ddd.AggregateRoot;

@AggregateRoot
@RequiredArgsConstructor(staticName = "of")
public class PostalCode {

    private final String countryCode;
    private final String countryName;
    private String postalCodeFormat;
    private String validationRegex;
}