package nl.hakktastic.postcalcodeinfoapi.application.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;

@Schema(description = "Response object reflecting the actual postal code information")
public record PostalCodeInfoResponse(
        @Schema(description = "CCA2 country code", example = "NL")
        String countryCode,
        @Schema(description = "Name of the country", example = "Netherlands")
        String countryName,
        @Schema(description = "Format of the postal code", example = "#### @@")
        String postalCodeFormat,
        @Schema(description = "Regular expression to validate the postal code", example = "^(\\\\d{4}[A-Z]{2})$")
        String validationRegex
) {

    public static PostalCodeInfoResponse from(final PostalCodeView postalCodeView) {
        return new PostalCodeInfoResponse(
                postalCodeView.countryCode(),
                postalCodeView.countryName(),
                postalCodeView.postalCodeFormat(),
                postalCodeView.validationRegex()
        );
    }
}