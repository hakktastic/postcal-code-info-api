package nl.hakktastic.postcalcodeinfoapi.domain.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeApi;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeSpi;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.PostalCode;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.CountryCode;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.PostalCodeInformationNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(staticName = "of")
public class PostalCodeService implements PostalCodeApi {

    private final PostalCodeSpi postalCodeSpi;

    @Override
    public PostalCodeView getPostalCodeInformationBy(String countryCodeValue) {

        final var countryCode = CountryCode.of(countryCodeValue);

        return postalCodeSpi.findFromRepositoryBy(countryCode.getValue()).orElseThrow(
                () -> new PostalCodeInformationNotFoundException(String.format("Postal code information for countryCode='%s' not found in repository", countryCode.getValue()))
        );
    }

    @Override
    public PostalCodeView addPostalCodeInformationBy(String countryCodeValue) {

        final var countryCode = CountryCode.of(countryCodeValue);
        final var externalApiResponse = postalCodeSpi.findFromExternalApiBy(countryCode.getValue()).orElseThrow(
                () -> new PostalCodeInformationNotFoundException(String.format("Postal code information for countryCode='%s' not found in external API", countryCode.getValue()))
        );
        final var postalCode = PostalCode.from(externalApiResponse);
        final var postalCodeView = postalCode.toPostalCodeView();

        postalCodeSpi.addToRepository(postalCodeView);

        return postalCodeView;
    }
}