package nl.hakktastic.postcalcodeinfoapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Postal Code Information API",
                description = "Demo REST API implementation to retrieve and store postal code information from an external API",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(url = "https://github.com/hakktastic/postal-code-info-api", email = "hakktastic@gmail.com")
        )
)
@SpringBootApplication
public class PostcalCodeInfoApiApplication {

    static void main(String[] args) {
        SpringApplication.run(PostcalCodeInfoApiApplication.class, args);
    }

}