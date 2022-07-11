package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.dto.requests.PublishProductOfferingRequest;
import eu._5gzorro.manager.api.dto.requests.UpdateProductOfferingRequest;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.ExecutionException;

@Tag(name = "Product Offer")
@RestController
@RequestMapping("/product-offer")
public class ProductOfferingController {
    private final ProductOfferingDriver driver;

    public ProductOfferingController(ProductOfferingDriver driver) {
        this.driver = driver;
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Published product offering."
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Error during publishing."
        )
    })
    @PostMapping
    public ResponseEntity<?> publishProductOffering(@Valid @RequestBody @NotNull PublishProductOfferingRequest request) {
        try {
            driver.publishProductOffering(
                request.toOfferDetails(),
                request.getInvitations(),
                request.getVerifiableCredentials(),
                null,
                request.getDid()
            );
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        return ResponseEntity.ok().body(true);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product offering removed"
        )
    })
    @DeleteMapping("/{offerId}")
    public ResponseEntity<Boolean> removeProductOffering(@PathVariable("offerId") String offerId) {
        driver.removeProductOffer(
            offerId,
            null
        );
        return ResponseEntity.ok().body(true);
    }

    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product offering updated"
        )
    })
    @PutMapping("/{offerId}")
    public ResponseEntity<Boolean> updateProductOffering(
        @PathVariable("offerId") String offerId,
        @Valid @RequestBody UpdateProductOfferingRequest request
    ) {
        driver.updateProductOffer(
            request.toOfferDetails(),
            null
        );
        return ResponseEntity.ok().body(true);
    }

}
