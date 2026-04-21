package nl.hakktastic.postcalcodeinfoapi.domain;

import java.util.Optional;

public interface PostalCodeRepository {

    Optional<PostalCode> findInfoByCountryCode(String value);

    void add(PostalCode postalCode);
}