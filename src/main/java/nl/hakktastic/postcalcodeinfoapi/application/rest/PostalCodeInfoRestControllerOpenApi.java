package nl.hakktastic.postcalcodeinfoapi.application.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface PostalCodeInfoRestControllerOpenApi {

    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Postal Code information returned successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PostalCodeInfoResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Postal Code information not found in internal repository",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))}
            )
    })
    @Operation(summary = "retrieve postal code information from internal repository based on provided country code")
    ResponseEntity<PostalCodeInfoResponse> getPostalCodeInfo(
            @PathVariable
            @Parameter(description = "Country Code according to CCA2 specification")
            String countryCode
    );

    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Postal Code information created successfully in internal repository",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PostalCodeInfoResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Postal Code information already exists in internal repository",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))}
            )
    })
    @Operation(summary = "add postal code information to internal repository provided with information provided from an external API")
    ResponseEntity<PostalCodeInfoResponse> addPostalCodeInfo(
            @PathVariable
            @Parameter(description = "Country Code according to CCA2 specification")
            String countryCode);
}