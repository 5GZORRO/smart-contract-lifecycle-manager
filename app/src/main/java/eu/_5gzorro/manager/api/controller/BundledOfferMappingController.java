package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.dto.responses.ApiErrorResponse;
import eu._5gzorro.manager.api.model.entity.BundledOfferMapping;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingExistsException;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Bundled Offer Mapping")
@RequestMapping("/api/v1/bundled-offer-mapping")
public interface BundledOfferMappingController {

    @Operation(description = "Save a Bundled Offer Mapping for a Bundle Offer DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The saved Bundled Offer Mapping",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BundledOfferMapping.class)) }),
            @ApiResponse(responseCode = "400", description = "Bundled Offer Mapping exists for this Bundle Offer DID",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    ResponseEntity<?> saveBundledOfferMapping(@RequestBody final BundledOfferMapping bundledOfferMapping) throws BundledOfferMappingExistsException;

    @Operation(description = "List the saved Bundled Offer Mapping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A List of Bundled Offer Mapping",
                    content = {@Content(array = @ArraySchema(schema =
                    @Schema(implementation = BundledOfferMapping.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    ResponseEntity<?> getBundledOfferMappings();

    @Operation(description = "List the saved Bundled Offer Mapping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested Bundled Offer Mapping",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BundledOfferMapping.class)) }),
            @ApiResponse(responseCode = "404", description = "Bundled Offer Mapping not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("{bundleOfferDID}")
    ResponseEntity<?> getBundledOfferMapping(@PathVariable final String bundleOfferDID) throws BundledOfferMappingNotFoundException;

    @Operation(description = "Delete a Bundled Offer Mapping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Bundled Offer Mapping deleted" ),
            @ApiResponse(responseCode = "404", description = "Bundled Offer Mapping not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("{bundleOfferDID}")
    ResponseEntity<?> deleteBundledOfferMapping(@PathVariable final String bundleOfferDID) throws BundledOfferMappingNotFoundException;
}
