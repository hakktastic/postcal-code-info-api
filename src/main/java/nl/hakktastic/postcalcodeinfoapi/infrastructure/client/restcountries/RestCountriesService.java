package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries;

import nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response.CountryResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/v3.1/alpha")
public interface RestCountriesRestClient {

    @GetExchange("/{countryCode}?fields=cca2,name,postalCode")
    CountryResponse findBy(@PathVariable String countryCode);
}