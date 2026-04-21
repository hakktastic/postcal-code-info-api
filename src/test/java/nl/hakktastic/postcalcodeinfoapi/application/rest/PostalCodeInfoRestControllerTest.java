package nl.hakktastic.postcalcodeinfoapi.application.rest;

import nl.hakktastic.postcalcodeinfoapi.PostgreSqlContainerConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.client.RestTestClient;

@Import(PostgreSqlContainerConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostalCodeInfoRestControllerTest {

    private static final String PATH_API_V1_POSTAL_CODES = "api/v1/postalcodes/{countryCode}";
    private static final String QUERY_PARAM_VALUE_NL_EXISTING = "NL";
    private static final String QUERY_PARAM_VALUE_GR_NON_EXISTING = "GR";

    @LocalServerPort
    private int port;

    private RestTestClient restTestClient;

    @BeforeEach
    void setup() {
        restTestClient = RestTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
    }

    @Test
    void givenPostalCodeInfoExists_whenGetPostalCodeInfo_thenReturnOK(){

        restTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(PATH_API_V1_POSTAL_CODES)
                        .build(QUERY_PARAM_VALUE_NL_EXISTING)
                )
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.countryCode").isEqualTo(QUERY_PARAM_VALUE_NL_EXISTING)
                .jsonPath("$.countryName").isEqualTo("Netherlands")
                .jsonPath("$.postalCodeFormat").isEqualTo("#### @@")
                .jsonPath("$.validationRegex").isEqualTo("^(\\d{4}[A-Z]{2})$");
    }

    @Test
    void givenPostalCodeInfoDoesNotExists_whenGetPostalCodeInfo_thenReturnNotFound(){

        restTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(PATH_API_V1_POSTAL_CODES)
                        .build(QUERY_PARAM_VALUE_GR_NON_EXISTING)
                )
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.status").isEqualTo(HttpStatus.NOT_FOUND.value())
                .jsonPath("$.title").isEqualTo("Postal Code Information Not Found")
                .jsonPath("$.instance").isEqualTo("/api/v1/postalcodes/GR")
                .jsonPath("$.detail").isEqualTo("Postal code information for countryCode='GR' not found in repository");
    }
}