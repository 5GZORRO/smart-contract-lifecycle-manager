package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.controller.dto.ServiceLevelAgreementDto;
import eu._5gzorro.manager.api.controller.dto.responses.ApiErrorResponse;
import eu._5gzorro.manager.api.controller.dto.responses.PagedSlaResponse;
import eu._5gzorro.manager.api.model.PageableOperation;
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

@Tag(name = "Service Level Agreement")
@RestController
@RequestMapping("/service-level-agreement")
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

    @Operation(description = "Get an SLA by DID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "An SLA matching the provided id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceLevelAgreementDto.class, name = "Service Level Agreement")) }),
            @ApiResponse(responseCode = "400", description = "Invalid id was provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping("{id}")
    ResponseEntity<ServiceLevelAgreementDto> getServiceLevelAgreement(@PathVariable final String id);

    @Operation(description = "Create a new Service Level Agreement definition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "A SLA definition was created successfully.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Prose Template definition provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping
    ResponseEntity<ServiceLevelAgreementDto> createServiceLevelAgreement(@RequestBody final ServiceLevelAgreementDto sla);

//    @Operation(description = "Approve/Reject a newly proposed template or proposal to remove a template", tags= { "admin" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "The prose template status was updated successfully"),
//            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
//            @ApiResponse(responseCode = "404", description = "A prose template couldn't be found with the provided ID",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @PutMapping("{id}/identity}")
//    ResponseEntity<Void> updateTemplateIdentity(@PathVariable final UUID templateHandle, @Valid @RequestBody final DIDStateDto state);
//
//
    @Operation(description = "Delete an SLA definition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The SLA was deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @DeleteMapping("{id}")
    ResponseEntity<String> removeServiceLevelAgreeement(@PathVariable String id);



}
