package nl.hakktastic.postcalcodeinfoapi.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCode;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
class PostalCodeRepositoryAdapter implements PostalCodeRepository {

    @Override
    public Optional<PostalCode> findInfoByCountryCode(String value) {
        return Optional.empty();
    }

    @Override
    public void add(final PostalCode postalCode) {


    }
}