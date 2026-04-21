package nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.response;

import lombok.Getter;
import lombok.ToString;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeView;

@Getter
@ToString
public class CountryResponse {

    private PostalCode postalCode;
    private Name name;
    private String cca2;

    public PostalCodeView toPostalCodeView(){

        return new PostalCodeView(
                cca2,
                name.getCommon(),
                postalCode.getFormat(),
                postalCode.getRegex()
        );
    }
}