package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.controller.dto.requests.ChangeProductOrderRequest;
import eu._5gzorro.manager.api.controller.dto.requests.PublishProductOrderRequest;
import eu._5gzorro.manager.api.httpClient.RSOCClient;
import eu._5gzorro.manager.api.httpClient.requests.SLAClient;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementNotFoundException;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementService;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product_order.OrderItem;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Product Order")
@RestController
@RequestMapping("/product-order")
public class ProductOrderController {
  private final ProductOrderDriver driver;

  @Autowired
  private RSOCClient rsocClient;

  @Autowired
  private SLAClient slaClient;

  @Autowired
  private ServiceLevelAgreementService serviceLevelAgreementService;

  public ProductOrderController(ProductOrderDriver driver) {
    this.driver = driver;
  }

  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Published product order")})
  @PostMapping
  public ResponseEntity<Boolean> publishProductOrder(
      @Valid @RequestBody @NotNull PublishProductOrderRequest request) {
    List<OrderItem> orderItems = request.getProductOrder().getOrderItem();
    List<ServiceLevelAgreement> serviceLevelAgreements = new ArrayList<>();
    for(OrderItem orderItem : orderItems) {
      ProductOffering po = rsocClient.getPoById(URI.create(orderItem.getProductOffering().getHref()));
      try {
        serviceLevelAgreements.add(slaClient.getSLAById(URI.create(po.getServiceLevelAgreement().getHref())));
      } catch (ServiceLevelAgreementNotFoundException ignored) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
    }

    driver.publishProductOrder(
        request.toOrderDetails(),
        request.getInvitations(),
        request.getVerifiableCredentials(),
        null,
        serviceLevelAgreements);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Propose change product order")})
  @PutMapping("/{orderId}")
  public ResponseEntity<Boolean> changeProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId,
      @Valid @RequestBody @NotNull ChangeProductOrderRequest request) {
    driver.proposeChangeProductOrder(orderId, request.toOrderDetails(), request.getInvitations());

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Accept change product order")})
  @PutMapping("/{orderId}/acceptChange")
  public ResponseEntity<Boolean> acceptChangeProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId) {
    driver.acceptChangeProposalProductOrder(orderId);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reject change product order")})
  @PutMapping("/{orderId}/rejectChange")
  public ResponseEntity<Boolean> rejectChangeProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId) {
    driver.rejectChangeProductOrder(orderId);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Provision product order")})
  @PutMapping("/{orderId}/provision")
  public ResponseEntity<Boolean> provisionProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId) {
    driver.provisionProductOrder(orderId);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "End product order")})
  @PutMapping("/{orderId}/end")
  public ResponseEntity<Boolean> endProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId) {
    driver.endProductOrder(orderId);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Approve product order")})
  @PutMapping("/{orderId}/approve")
  public ResponseEntity<Boolean> approveProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId) {
    driver.approveProductOrder(orderId);

    return ResponseEntity.ok().body(true);
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reject product order")})
  @PutMapping("/{orderId}/reject")
  public ResponseEntity<Boolean> rejectProductOrder(
      @Valid @RequestParam("orderId") @NotNull String orderId,
      @RequestBody String rejectionReason) {
    driver.rejectProductOrder(orderId, rejectionReason);

    return ResponseEntity.ok().body(true);
  }
}
