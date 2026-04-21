package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostalCode {

    private String format;
    private String regex;
}