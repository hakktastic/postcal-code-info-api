package nl.hakktastic.postcalcodeinfoapi.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class PostalCodeService {

    private final PostalCodeRepository postalCodeRepository;

    public PostalCode createPostalCodeInformation(String countryCodeValue) {

        final var countryCode = CountryCode.of(countryCodeValue);
        final var postalCode = postalCodeRepository.findInfoByCountryCode(countryCode.getValue());

        if(postalCode.isPresent()){
            final var message= String.format("Postal code information for countryCode='%s' already exists", countryCode.getValue());
            throw new PostalCodeAlreadyExistsException(message);
        }

        return postalCodeRepository.add(countryCode.getValue()).orElseThrow(
                () -> new RuntimeException("test")
        );
    }
}