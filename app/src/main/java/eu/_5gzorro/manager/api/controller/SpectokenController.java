package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.dto.requests.CreatePrimitiveSpectokenRequest;
import eu._5gzorro.manager.api.dto.requests.IssueDerivativeSpectokenRequest;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.tm_forum.models.spectoken.GetDerivativeSpectokenResponse;
import eu._5gzorro.tm_forum.models.spectoken.GetPrimitiveSpectokenResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Tag(name = "Spectoken")
@RestController
@RequestMapping("/spectoken")
public class SpectokenController {
    private final PrimitiveSpectokenDriver primitiveSpectokenDriver;
    private final DerivativeSpectokenDriver derivativeSpectokenDriver;

    public SpectokenController(PrimitiveSpectokenDriver primitiveSpectokenDriver, DerivativeSpectokenDriver derivativeSpectokenDriver) {
        this.primitiveSpectokenDriver = primitiveSpectokenDriver;
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Retrieved Derivative Spectokens",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = GetDerivativeSpectokenResponse.class)
            )
        )
    })
    @GetMapping("/derivative")
    public ResponseEntity<?> getDerivativeSpectokens() {
        List<GetDerivativeSpectokenResponse> derivativeSpectokens = new ArrayList<>();
        try {
            derivativeSpectokens = derivativeSpectokenDriver.getDerivativeSpectokens();
        } catch (ExecutionException | InterruptedException e) {
            ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.ok().body(derivativeSpectokens);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Retrieved Primitive Spectokens"
        )
    })
    @GetMapping("/primitive")
    public ResponseEntity<?> getPrimitiveSpectokens() {
        List<GetPrimitiveSpectokenResponse> primitiveSpectokens = new ArrayList<>();
        try {
            primitiveSpectokens = primitiveSpectokenDriver.getPrimitiveSpectokens();
        } catch (ExecutionException | InterruptedException e) {
            ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.ok().body(primitiveSpectokens);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Create primitive Spectoken"
        )
    })
    @PostMapping("/primitive")
    public ResponseEntity<Boolean> createPrimitiveSpectoken(
        @Valid @RequestBody @NotNull CreatePrimitiveSpectokenRequest request) {
        try {
            primitiveSpectokenDriver.createPrimitiveSpectoken(
                request.getStartDl(),
                request.getEndDl(),
                request.getStartUl(),
                request.getEndUl(),
                request.getStartDate(),
                request.getEndDate(),
                request.getDuplexMode(),
                request.getBand(),
                request.getTechnology(),
                request.getCountry(),
                request.getOwnerDid(),
                request.getLicense()
            );
        } catch (ExecutionException | InterruptedException e) {
            ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.ok().body(true);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Issue derivative Spectoken"
        )
    })
    @PostMapping("derivative/issue")
    public ResponseEntity<Boolean> issueDerivativeSpectoken(@Valid @RequestBody @NotNull IssueDerivativeSpectokenRequest request) {
        derivativeSpectokenDriver.issueDerivativeSpectoken(
            request.getOfferDid(),
            request.getOwnerDid()
        );
        return ResponseEntity.ok().body(true);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Redeem primitive Spectoken"
        )
    })
    @PutMapping("primitive/redeem/{licenseId}")
    public ResponseEntity<Boolean> invalidatePrimitiveSpectoken(@Valid @RequestParam("licenseId") @NotNull String licenseId) {
        primitiveSpectokenDriver.invalidatePrimitiveSpectoken(licenseId);
        return ResponseEntity.ok().body(true);
    }

}
