package nl.hakktastic.postcalcodeinfoapi.domain.internal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.ddd.ValueObject;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.InvalidValueObjectException;

@Slf4j
@Getter
@ToString
@ValueObject
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CountryCode {

    private static final int CCA2_COUNTRY_CODE_LENGTH = 2;

    private final String value;

    public static CountryCode of(final String value) {
        log.debug("provided value='{}'", value);

        shouldBeExactlyTwoCharacters(value);
        shouldContainOnlyLetters(value);

        return new CountryCode(value);
    }

    private static void shouldBeExactlyTwoCharacters(String value) {
        if(value.length() != CCA2_COUNTRY_CODE_LENGTH){
            throw new InvalidValueObjectException(String.format("provided value for countryCode='%s' should contain exactly two characters", value));
        }
    }

    private static void shouldContainOnlyLetters(String value) {
        if(!value.chars().allMatch(Character::isLetter)){
            throw new InvalidValueObjectException(String.format("provided value for countryCode='%s' should contain only letters", value));
        }
    }
}