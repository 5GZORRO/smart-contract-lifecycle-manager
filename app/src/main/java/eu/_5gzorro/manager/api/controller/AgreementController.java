package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateDto;
import eu._5gzorro.manager.api.dto.responses.ApiErrorResponse;
import eu._5gzorro.manager.api.dto.responses.PagedAgreementResponse;
import eu._5gzorro.manager.api.model.PageableOperation;
import eu._5gzorro.tm_forum.models.agreement.Agreement;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Hidden
@Tag(name = "Agreement")
@RequestMapping("/api/v1/agreement")
public interface AgreementController {

    @Operation(description = "Retrieve a paged collection of Agreements according to paging and filter parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A Paged List of Agreements",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PagedAgreementResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid page or filter parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping
    @PageableOperation
    ResponseEntity<PagedAgreementResponse> getAgreements(final @Parameter(hidden = true) Pageable pageable);

    @Operation(description = "Get an agreement by id or DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "An agreement matching the provided identifier",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Agreement.class, name = "Agreement")) }),
            @ApiResponse(responseCode = "400", description = "Invalid id was provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An  couldn't be found with the provided Identifier",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping("{identifier}")
    ResponseEntity<Agreement> getAgreement(@PathVariable final String identifier) throws JsonProcessingException;

    @Operation(description = "Create a new Service Level Agreement definition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "A Agreement definition was created successfully.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Agreement definition provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping
    ResponseEntity<UUID> createAgreement(@RequestBody final Agreement agreement) throws JsonProcessingException;

    @Operation(description = "Callback endpoint to handle processing async DID identifier generation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Agreement was updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An Agreement couldn't be found with the provided ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping("{id}/identity")
    ResponseEntity<Void> updateTemplateIdentity(@PathVariable final UUID id, @Valid @RequestBody final DIDStateDto state) throws JsonProcessingException;


    @Operation(description = "Delete an Agreement definition by DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Agreement was deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An Agreement couldn't be found with the provided DID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @DeleteMapping("{id}")
    ResponseEntity<Void> removeAgreement(@PathVariable String did);
}
