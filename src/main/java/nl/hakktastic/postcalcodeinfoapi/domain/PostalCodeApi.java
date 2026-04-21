package nl.hakktastic.postcalcodeinfoapi.domain;

import nl.hakktastic.postcalcodeinfoapi.shared.architecture.hexagonal.Port;

@Port
public interface PostalCodeApi {

    PostalCodeView getPostalCodeInformationBy(String countryCodeValue);
    PostalCodeView addPostalCodeInformationBy(String countryCodeValue);
}