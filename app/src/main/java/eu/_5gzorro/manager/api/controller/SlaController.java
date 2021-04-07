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
//import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SLA")
@RestController
@RequestMapping("/sla")
public interface SlaController {

//    @Operation(description = "Retrieve a paged collection of SLAs according to paging and filter parameters")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "A Paged List of SLAs",
//                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PagedSlaResponse.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid page or filter parameters provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @GetMapping
//    @PageableOperation
//    ResponseEntity<PagedSlaResponse> getLegalProseTemplates(
//            final @Parameter(hidden = true) Pageable pageable,
//            @RequestParam(required = false) final String filterText);

//    @Operation(description = "Get an SLA by DID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "An SLA matching the provided id",
//                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceLevelAgreementDto.class, name = "Service Level Agreement")) }),
//            @ApiResponse(responseCode = "400", description = "Invalid id was provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
//            @ApiResponse(responseCode = "404", description = "An SLA couldn't be found with the provided ID",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @GetMapping("{id}")
//    ResponseEntity<ServiceLevelAgreementDto> getLegalProseTemplate(@PathVariable final String id);
//
//    @Operation(description = "Propose a new Legal Prose Template. The request will be subject to a governance process before becoming available in the marketplace. Proposal ID is returned in the response", tags= { "trader", "admin" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "A Legal Prose Template was created successfully. The temporary handle of the newly created template is returned.",
//                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid Prose Template definition provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(encoding = @Encoding(name = "proposeTemplateRequest", contentType = "application/json")))
//    @PostMapping(value="", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    ResponseEntity<UUID> proposeNewLegalProseTemplate(
//            @Valid @RequestPart(value ="proposeTemplateRequest") final ProposeTemplateRequest proposeTemplateRequest,
//            @Valid @RequestParam(value = "templateFile") @ValidAccordTemplate final MultipartFile templateFile);
//
//
//    @Operation(description = "Complete the creation of a template", tags= { "admin" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "The template's DID was assigned and a governance proposal generated to manage the template's approval"),
//            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
//            @ApiResponse(responseCode = "404", description = "A prose template couldn't be found with the provided handle",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @PutMapping("{handle}/approve/{accept}")
//    ResponseEntity<Void> setLegalStatementTemplateApprovalStatus(@PathVariable final String id, @PathVariable final boolean accept);
//
//
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
//    @Operation(description = "Propose the removal of a Legal Prose Template by DID. The request will be subject to a governance process before becoming available in the marketplace", tags= { "trader", "admin" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "The prose template status was marked for deletion successfully. Subject to governance decision. Proposal ID is returned in the response"),
//            @ApiResponse(responseCode = "400", description = "Invalid parameters provided",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
//            @ApiResponse(responseCode = "404", description = "A prose template couldn't be found with the provided ID",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
//    })
//    @DeleteMapping("{id}")
//    ResponseEntity<String> removeLegalProseTemplate(@PathVariable String id);
//


}
