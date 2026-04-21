package nl.hakktastic.postcalcodeinfoapi.domain.internal;

import nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject.CountryCode;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.InvalidValueObjectException;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CountryCodeTest {

    @Test
    void shouldCreateCountryCode_whenValidInput() {
        CountryCode countryCode = CountryCode.of("NL");

        assertThat(countryCode).isNotNull();
        assertThat(countryCode.getValue()).isEqualTo("NL");
    }

    @Test
    void shouldThrowException_whenLengthIsLessThanTwo() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of("N"))
                .withMessageContaining("exactly two characters");
    }

    @Test
    void shouldThrowException_whenLengthIsMoreThanTwo() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of("NLD"))
                .withMessageContaining("exactly two characters");
    }

    @Test
    void shouldThrowException_whenContainsNonLetters() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of("N1"))
                .withMessageContaining("only letters");
    }

    @Test
    void shouldThrowException_whenContainsSpecialCharacters() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of("@#"))
                .withMessageContaining("only letters");
    }

    @Test
    void shouldAllowLowerCaseLetters() {
        CountryCode countryCode = CountryCode.of("nl");

        assertThat(countryCode.getValue()).isEqualTo("nl");
    }

    @Test
    void shouldThrowException_whenValueIsNull() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of(null));
    }

    @Test
    void shouldThrowException_whenValueIsBlank() {
        assertThatExceptionOfType(InvalidValueObjectException.class)
                .isThrownBy(() -> CountryCode.of(Strings.EMPTY));
    }
}