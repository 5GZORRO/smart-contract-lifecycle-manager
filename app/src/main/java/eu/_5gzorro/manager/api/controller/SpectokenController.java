package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.dto.requests.CreatePrimitiveSpectokenRequest;
import eu._5gzorro.manager.api.dto.requests.IssueDerivativeSpectokenRequest;
import eu._5gzorro.manager.api.model.entity.OrderOfferMapping;
import eu._5gzorro.manager.api.repository.OrderOfferMappingRepository;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.*;
import eu._5gzorro.tm_forum.models.spectoken.GetDerivativeSpectokenResponse;
import eu._5gzorro.tm_forum.models.spectoken.GetPrimitiveSpectokenResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Tag(name = "Spectoken")
@RestController
@RequestMapping("/spectoken")
public class SpectokenController {
    private final PrimitiveSpectokenDriver primitiveSpectokenDriver;
    private final DerivativeSpectokenDriver derivativeSpectokenDriver;
    private final SpectokenNftDriver spectokenNftDriver;
    private final ProductOrderDriver productOrderDriver;
    private final ProductOfferingDriver productOfferingDriver;

    @Autowired
    private OrderOfferMappingRepository orderOfferMappingRepository;

    public SpectokenController(PrimitiveSpectokenDriver primitiveSpectokenDriver, DerivativeSpectokenDriver derivativeSpectokenDriver, SpectokenNftDriver spectokenNftDriver, ProductOrderDriver productOrderDriver, ProductOfferingDriver productOfferingDriver) {
        this.primitiveSpectokenDriver = primitiveSpectokenDriver;
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
        this.spectokenNftDriver = spectokenNftDriver;
        this.productOrderDriver = productOrderDriver;
        this.productOfferingDriver = productOfferingDriver;
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
        List<GetDerivativeSpectokenResponse> derivativeSpectokens;
        try {
            derivativeSpectokens = derivativeSpectokenDriver.getDerivativeSpectokens();
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(500).body(e.getMessage());
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
        List<GetPrimitiveSpectokenResponse> primitiveSpectokens;
        try {
            primitiveSpectokens = primitiveSpectokenDriver.getPrimitiveSpectokens();
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.ok().body(primitiveSpectokens);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Retrieved Spectoken NFTs"
        )
    })
    @GetMapping("/nfts")
    public ResponseEntity<?> getNfts() {
        return ResponseEntity.ok().body(spectokenNftDriver.getNftResponses());
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Create primitive Spectoken"
        )
    })
    @PostMapping("/primitive")
    public ResponseEntity<?> createPrimitiveSpectoken(
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
            return ResponseEntity.status(500).body(e.getMessage());
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
    public ResponseEntity<?> issueDerivativeSpectoken(@Valid @RequestBody @NotNull IssueDerivativeSpectokenRequest request) {
        try {
            return ResponseEntity.ok().body(derivativeSpectokenDriver.issueDerivativeSpectoken(
                request.getOfferDid(),
                request.getOwnerDid()
            ));
        } catch (ExecutionException | InterruptedException | SpectokenException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Redeem primitive Spectoken"
        )
    })
    @PutMapping("primitive/redeem/{licenseDid}")
    public ResponseEntity<?> invalidatePrimitiveSpectoken(@Valid @RequestParam("licenseDid") @NotNull String licenseDid) {
        List<String> offerDids;
        try {
            offerDids = primitiveSpectokenDriver.invalidatePrimitiveSpectoken(licenseDid);
            for (String offerDId : offerDids) {
                productOfferingDriver.removeProductOffer(offerDId);
                List<OrderOfferMapping> orderOfferMappings = orderOfferMappingRepository.findByOfferDid(offerDId);
                for (OrderOfferMapping orderOfferMapping : orderOfferMappings) {
                    productOrderDriver.endProductOrder(orderOfferMapping.getOrderDid(), offerDId);
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.ok().body(true);
    }

}
