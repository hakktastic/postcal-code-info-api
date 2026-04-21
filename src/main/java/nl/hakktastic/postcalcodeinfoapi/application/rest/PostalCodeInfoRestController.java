package nl.hakktastic.postcalcodeinfoapi.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.postcalcodeinfoapi.domain.PostalCodeApi;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = PostalCodeInfoRestController.PATH_REQUEST_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
class PostalCodeInfoRestController implements PostalCodeInfoRestControllerOpenApi {

    protected static final String PATH_REQUEST_MAPPING = "api/v1/postalcodes";

    private final PostalCodeApi postalCodeApi;

    @GetMapping("/{countryCode}")
    public ResponseEntity<PostalCodeInfoResponse> getPostalCodeInfo(@PathVariable String countryCode) {

        log.info("retrieving postal code information for countryCode='{}'", countryCode);
        final var postalCodeInformation = postalCodeApi.getPostalCodeInformationBy(countryCode);

        final var postalCodeInfoResponse = PostalCodeInfoResponse.from(postalCodeInformation);
        log.debug("Returning postalCodeInfoResponse='{}'", postalCodeInfoResponse);

        return ResponseEntity.ok(postalCodeInfoResponse);
    }

    @PostMapping("/{countryCode}")
    public ResponseEntity<PostalCodeInfoResponse> addPostalCodeInfo(@PathVariable String countryCode) {

        log.info("adding postal code information to internal repository for countryCode='{}'", countryCode);
        final var postalCodeInformation = postalCodeApi.addPostalCodeInformationBy(countryCode);

        final var postalCodeInfoResponse = PostalCodeInfoResponse.from(postalCodeInformation);
        log.debug("Returning postalCodeInfoResponse='{}'", postalCodeInfoResponse);

        return ResponseEntity.created(URI.create(PATH_REQUEST_MAPPING + countryCode))
                .body(postalCodeInfoResponse);
    }
}