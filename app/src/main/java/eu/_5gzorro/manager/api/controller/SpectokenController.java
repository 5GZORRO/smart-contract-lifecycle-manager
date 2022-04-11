package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.dto.requests.CreateDerivativeSpectokenRequest;
import eu._5gzorro.manager.api.dto.requests.CreatePrimitiveSpectokenRequest;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
                    description = "Create primitive Spectoken"
            )
    })
    @PostMapping("/primitive")
    public ResponseEntity<Boolean> createPrimitiveSpectoken(
            @Valid @RequestBody @NotNull CreatePrimitiveSpectokenRequest request) {
        primitiveSpectokenDriver.createPrimitiveSpectoken(
                request.getDid(),
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
        return ResponseEntity.ok().body(true);
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Create derivative Spectoken"
            )
    })
    @PostMapping("derivative")
    public ResponseEntity<Boolean> createDerivativeSpectoken(
            @Valid @RequestBody @NotNull CreateDerivativeSpectokenRequest request) {
        derivativeSpectokenDriver.createDerivativeSpectoken(
                request.getDid(),
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
                request.getPrimitiveDid()
        );
        return ResponseEntity.ok().body(true);
    }

}
