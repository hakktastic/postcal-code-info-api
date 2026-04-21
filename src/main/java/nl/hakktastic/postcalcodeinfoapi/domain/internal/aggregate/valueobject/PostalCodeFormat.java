package nl.hakktastic.postcalcodeinfoapi.domain.internal.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.ddd.ValueObject;

@Slf4j
@Getter
@ToString
@ValueObject
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PostalCodeFormat {

    private final String value;

    public static PostalCodeFormat of(final String value) {
        log.debug("provided value='{}'", value);
        return new PostalCodeFormat(value);
    }
}