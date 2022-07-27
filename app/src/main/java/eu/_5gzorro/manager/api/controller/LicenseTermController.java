package eu._5gzorro.manager.api.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateCSDto;
import eu._5gzorro.manager.api.dto.requests.UpdateLicenseTermStateRequest;
import eu._5gzorro.manager.api.dto.responses.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "License Term")
@RequestMapping("/api/v1/license-term")
public interface LicenseTermController {

    @Operation(description = "Get all License Terms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of available License Terms",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = LicenseTerm.class))) }),
            @ApiResponse(responseCode = "500", description = "Error occurred while fetching License Terms",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    ResponseEntity<?> getLicenseTerms();

    @Operation(description = "Get License Term by ID or DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The License Term matching the provided identifier",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LicenseTerm.class)) }),
            @ApiResponse(responseCode = "400", description = "An invalid identifier was provided",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "A License Term couldn't be found with " +
                    "the provided identifier", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Error occurred while fetching License Term",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{identifier}")
    ResponseEntity<?> getLicenseTerm(@PathVariable final String identifier) throws JsonProcessingException;

    @Operation(description = "Create a new License Term definition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "A License Term definition was created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid License Term definition provided",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Error occurred while creating License Term definition",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping
    ResponseEntity<UUID> createLicenseTerm(@RequestBody @Valid  final LicenseTerm licenseTerm)
            throws JsonProcessingException;

    @Operation(description = "Callback endpoint to handle async processing of DID identifier generation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The License Term was updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "A License Term couldn't be found with " +
                    "the provided identifier", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Error occurred while updating License Term definition",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping("{licenseTermId}/identity")
    ResponseEntity<Void> updateTemplateIdentity(@PathVariable final UUID licenseTermId,
                                                @Valid @RequestBody final DIDStateCSDto state)
            throws JsonProcessingException;

    @Operation(description = "Delete a License Term definition by DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The License Term was deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "A License Term couldn't be found with " +
                    "the provided identifier", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Error occurred while updating License Term definition",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @DeleteMapping("{did}")
    ResponseEntity<Void> deleteLicenseTerm(@PathVariable String did);

    @Operation(description = "Update the state of a License Term in the DLT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "License Term state updated successfully"),
            @ApiResponse(responseCode = "500", description = "Error occurred while updating License Term DLT state")
    })
    ResponseEntity<Void> updateLicenseTermState(@RequestBody @Valid UpdateLicenseTermStateRequest request);
}
