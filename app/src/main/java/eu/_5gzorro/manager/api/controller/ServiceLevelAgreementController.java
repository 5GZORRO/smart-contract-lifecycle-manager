package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateDto;
import eu._5gzorro.manager.api.dto.responses.ApiErrorResponse;
import eu._5gzorro.manager.api.dto.responses.PagedSlaResponse;
import eu._5gzorro.manager.api.model.PageableOperation;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
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

@Tag(name = "Service Level Agreement")
@RequestMapping("/api/v1/service-level-agreement")
public interface ServiceLevelAgreementController {

    @Operation(description = "Retrieve a paged collection of Service Level Agreements according to paging and filter parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A Paged List of Service Level Agreements",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PagedSlaResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid page or filter parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping
    @PageableOperation
    ResponseEntity<PagedSlaResponse> getServiceLevelAgreements(final @Parameter(hidden = true) Pageable pageable);

    @Operation(description = "Get an SLA by id or DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "An SLA matching the provided identifier",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceLevelAgreement.class, name = "Service Level Agreement")) }),
            @ApiResponse(responseCode = "400", description = "Invalid id was provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided Identifier",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping("{identifier}")
    ResponseEntity<ServiceLevelAgreement> getServiceLevelAgreement(@PathVariable final String identifier) throws JsonProcessingException;

    @Operation(description = "Create a new Service Level Agreement definition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "A SLA definition was created successfully.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid SLA definition provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping
    ResponseEntity<UUID> createServiceLevelAgreement(@RequestBody final ServiceLevelAgreement sla) throws JsonProcessingException;

    @Operation(description = "Callback endpoint to handle processing async DID identifier generation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The SLA was updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping("{slaId}/identity")
    ResponseEntity<Void> updateTemplateIdentity(@PathVariable final UUID slaId, @Valid @RequestBody final DIDStateDto state) throws JsonProcessingException;


    @Operation(description = "Delete an SLA definition by DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The SLA was deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided DID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @DeleteMapping("{did}")
    ResponseEntity<Void> removeServiceLevelAgreement(@PathVariable String did);
}
