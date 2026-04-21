package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NativeName {

    private String official;
    private String common;
}