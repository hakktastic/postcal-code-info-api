package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class Name {

    private String common;
    private String official;
    private Map<String, NativeName> nativeName;
}