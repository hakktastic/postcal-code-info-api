package nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.ddd.ValueObject;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.InvalidValueObjectException;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Getter
@ToString
@ValueObject
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CountryName {

    private final String value;

    public static CountryName of(final String value) {
        log.debug("provided value='{}'", value);
        shouldNotBeBlank(value);
        return new CountryName(value);
    }

    private static void shouldNotBeBlank(String value) {
        if(StringUtils.isBlank(value)){
            throw new InvalidValueObjectException(String.format("provided value for countryName='%s' should not be blank", value));
        }
    }
}