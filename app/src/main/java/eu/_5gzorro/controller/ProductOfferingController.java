package eu._5gzorro.controller;

import eu._5gzorro.controller.dto.PublishProductOfferingRequest;
import eu._5gzorro.controller.dto.UpdateProductOfferingRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Product Offer")
@RestController
@RequestMapping("/product-offer")
public class ProductOfferingController {

  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Published product offering"
      )
  })
  @PostMapping
  public ResponseEntity<Boolean> publishProductOffering(
      @RequestBody @NotNull PublishProductOfferingRequest request) {
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
      @RequestBody UpdateProductOfferingRequest request
  ) {
    return ResponseEntity.ok().body(true);
  }

}
