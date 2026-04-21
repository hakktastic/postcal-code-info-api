package nl.hakktastic.postcalcodeinfoapi.infrastructure.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;

/**
 * @see <a href="https://gitlab.com/restcountries/restcountries/-/blob/master/FIELDS.md">rest countries Fields</a>
 */
@Getter
@Setter
@ToString
@Entity(name = "postal_code")
public class PostalCodeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 2, message = "Country Code must be exactly 2 characters")
    private String countryCode;

    @NotBlank(message = "The official Country Name must not be blank")
    private String countryName;

    private String postalCodeFormat;

    private String validationRegex;

    public static PostalCodeJpaEntity from(final PostalCodeView postalCodeView) {

        final var postalCodeJpaEntity = new PostalCodeJpaEntity();
        postalCodeJpaEntity.setCountryCode(postalCodeView.countryCode());
        postalCodeJpaEntity.setCountryName(postalCodeView.countryName());
        postalCodeJpaEntity.setPostalCodeFormat(postalCodeView.postalCodeFormat());
        postalCodeJpaEntity.setValidationRegex(postalCodeView.validationRegex());

        return postalCodeJpaEntity;
    }

    public PostalCodeView toPostalCodeView() {
        return new PostalCodeView(countryCode, countryName, postalCodeFormat, validationRegex);
    }
}