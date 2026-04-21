package nl.hakktastic.postcalcodeinfoapi.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeSpi;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;
import nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.RestCountriesService;
import nl.hakktastic.postcalcodeinfoapi.infrastructure.jpa.PostalCodeJpaEntity;
import nl.hakktastic.postcalcodeinfoapi.infrastructure.jpa.PostalCodeJpaRepository;
import nl.hakktastic.postcalcodeinfoapi.shared.architecture.hexagonal.Adapter;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.PostalCodeInformationAlreadyExistsException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Adapter
@Component
@RequiredArgsConstructor
class PostalCodeSpiAdapter implements PostalCodeSpi {

    private final PostalCodeJpaRepository postalCodeJpaRepository;
    private final RestCountriesService restCountriesService;

    @Override
    public void addToRepository(PostalCodeView postalCodeView) {

        log.info("adding postal code information to JPA Repository for postalCodeView='{}'", postalCodeView);

        if(findFromRepositoryBy(postalCodeView.countryCode()).isEmpty()){

            final var newPostalCodeJpaEntity = PostalCodeJpaEntity.from(postalCodeView);
            log.debug("postalCodeJpaEntity='{}'", newPostalCodeJpaEntity);

            postalCodeJpaRepository.save(newPostalCodeJpaEntity);

        } else{
            throw new PostalCodeInformationAlreadyExistsException(String.format("Postal code information for countryCode='%s' already exists", postalCodeView.countryCode()));
        }
    }

    @Override
    public Optional<PostalCodeView> findFromRepositoryBy(String countryCode) {

        log.info("Searching in JPA repository for postal code information by countryCode='{}'", countryCode);
        final var postalCodeJpaEntity = postalCodeJpaRepository.findPostalCodeJpaEntityByCountryCode(countryCode);

        if(postalCodeJpaEntity.isPresent()){
            log.info("found postal code information in JPA repository for countryCode='{}'", countryCode);
            log.debug("postalCodeJpEntity='{}'", postalCodeJpaEntity);

            final var postalCodeView = postalCodeJpaEntity.get().toPostalCodeView();
            log.debug("postalCodeView='{}'", postalCodeView);

            return Optional.of(postalCodeView);
        }

        log.info("countryCode='{}' not found in JPA repository", countryCode);
        return Optional.empty();
    }

    @Override
    public Optional<PostalCodeView> findFromExternalApiBy(String countryCode) {

        log.info("Searching in REST Client 'https://restcountries.com' for postal code information by countryCode='{}'", countryCode);
        final var optionalCountryResponse = restCountriesService.findBy(countryCode);

        if(optionalCountryResponse.isPresent()) {
            log.info("Found countryCode='{}' in REST Client", countryCode);

            final var countryResponse = optionalCountryResponse.get();
            log.debug("countryResponse='{}'", countryResponse);

            return Optional.of(countryResponse.toPostalCodeView());
        }

        log.info("countryCode='{}'not found in REST Client 'https://restcountries.com'", countryCode);
        return Optional.empty();
    }
}