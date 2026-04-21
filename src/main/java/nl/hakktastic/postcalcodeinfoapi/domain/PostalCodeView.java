package nl.hakktastic.postcalcodeinfoapi.domain;

public record PostalCodeView (
        String countryCode,
        String countryName,
        String postalCodeFormat,
        String validationRegex) {
}