package nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate;

import lombok.AllArgsConstructor;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.CountryCode;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.CountryName;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.PostalCodeFormat;
import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.ValidationRegex;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.ddd.AggregateRoot;

@AggregateRoot
@AllArgsConstructor(staticName = "of")
public class PostalCode {

    private final CountryCode countryCode;
    private final CountryName countryName;
    private PostalCodeFormat postalCodeFormat;
    private ValidationRegex validationRegex;

    public static PostalCode from(PostalCodeView postalCodeView) {
        return PostalCode.of(
                CountryCode.of(postalCodeView.countryCode()),
                CountryName.of(postalCodeView.countryName()),
                PostalCodeFormat.of(postalCodeView.postalCodeFormat()),
                ValidationRegex.of(postalCodeView.validationRegex())
                );
    }

    public PostalCodeView toPostalCodeView() {
        return new PostalCodeView(
                countryCode.getValue(),
                countryName.getValue(),
                postalCodeFormat.getValue(),
                validationRegex.getValue()
        );
    }

    // business rules, policies and specifications for postal code
}