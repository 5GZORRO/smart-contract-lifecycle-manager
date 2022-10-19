package eu._5gzorro.manager.api.controller;

import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.api.controller.dto.requests.PublishProductOrderRequest;
import eu._5gzorro.manager.api.httpClient.RSOCClient;
import eu._5gzorro.manager.api.httpClient.requests.SCLCMClient;
import eu._5gzorro.manager.api.model.exception.LicenseTermNotFoundException;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementNotFoundException;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementService;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import eu._5gzorro.tm_forum.models.product_order.OrderItem;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
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
    private SCLCMClient sclcmClient;

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
        List<Pair<LicenseTerm, String>> licenseTerms = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            ProductOffering po = rsocClient.getPoById(URI.create(orderItem.getProductOffering().getHref()));
            ProductOfferingPrice pop = rsocClient.getPopById(URI.create(po.getProductOfferingPrice().get(0).getHref()));

            try {
                if (po.getServiceLevelAgreement() != null)
                    serviceLevelAgreements.add(sclcmClient.getSLAById(URI.create(po.getServiceLevelAgreement().getHref())));
                if (pop.getPricingLogicAlgorithm() != null && !pop.getPricingLogicAlgorithm().isEmpty()) {
                    if (pop.getPricingLogicAlgorithm().get(0) != null)
                        licenseTerms.add(new Pair<>(sclcmClient.getLicenseTermById(URI.create(pop.getPricingLogicAlgorithm()
                            .get(0).getHref())), rsocClient.getPoDID(URI.create(po.getHref().replace("productOffering",
                            "productOfferingStatus"))).getDid()));
                }
            } catch (ServiceLevelAgreementNotFoundException | LicenseTermNotFoundException ignored) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        driver.publishProductOrder(
            request.toOrderDetails(),
            request.getInvitations(),
            request.getVerifiableCredentials(),
            null,
            serviceLevelAgreements,
            licenseTerms
        );

        OrderOfferMapping orderOfferMapping = new OrderOfferMapping(request.getOfferDid(), request.getOrderDid());
        orderOfferMappingRepository.save(orderOfferMapping);

        return ResponseEntity.ok().body(true);
    }


    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "End product order")})
    @PutMapping("/{orderId}/end")
    public ResponseEntity<Boolean> endProductOrder(
        @Valid @PathVariable("orderId") @NotNull String orderId, @Param("offerDId") @NotNull String offerDid) {
        driver.endProductOrder(orderId, offerDid);

        return ResponseEntity.ok().body(true);
    }

}
