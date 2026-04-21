package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries;

import nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response.CountryResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Optional;

/**
 * @see <a href="https://restcountries.com">Rest Countries API</a>
 */
@HttpExchange("/v3.1/alpha")
public interface RestCountriesService {

    @GetExchange("/{countryCode}?fields=cca2,name,postalCode")
    Optional<CountryResponse> findBy(@PathVariable String countryCode);
}