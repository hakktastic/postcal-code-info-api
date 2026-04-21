package nl.hakktastic.postcalcodeinfoapi.domain;

import nl.hakktastic.postcalcodeinfoapi.shared.architecture.hexagonal.Port;

import java.util.Optional;

@Port
public interface PostalCodeSpi {

    void addToRepository(PostalCodeView postalCodeView);
    Optional<PostalCodeView> findFromRepositoryBy(String countryCode);
    Optional<PostalCodeView> findFromExternalApiBy(String countryCode);
}