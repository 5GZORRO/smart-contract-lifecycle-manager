package eu._5gzorro.manager.api.scheduled;

import eu._5gzorro.manager.api.model.entity.OrderOfferMapping;
import eu._5gzorro.manager.api.repository.OrderOfferMappingRepository;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.tm_forum.models.product_order.ProductOrderDto;
import eu._5gzorro.tm_forum.models.spectoken.DerivativeSpectokenDto;
import eu._5gzorro.tm_forum.models.spectoken.PrimitiveSpectokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Configuration
@EnableScheduling
public class CheckValidityDatesTask {

    private static final Logger log = LoggerFactory.getLogger(CheckValidityDatesTask.class);

    private final DerivativeSpectokenDriver derivativeSpectokenDriver;
    private final PrimitiveSpectokenDriver primitiveSpectokenDriver;
    private final ProductOrderDriver productOrderDriver;
    private final OrderOfferMappingRepository orderOfferMappingRepository;

    public CheckValidityDatesTask(DerivativeSpectokenDriver derivativeSpectokenDriver, PrimitiveSpectokenDriver primitiveSpectokenDriver, ProductOrderDriver productOrderDriver, OrderOfferMappingRepository orderOfferMappingRepository) {
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
        this.primitiveSpectokenDriver = primitiveSpectokenDriver;
        this.productOrderDriver = productOrderDriver;
        this.orderOfferMappingRepository = orderOfferMappingRepository;
    }

    @Scheduled(cron = "${cron.schedule.dates}")
    public void execute() {

        try {
            List<PrimitiveSpectokenDto> primitiveSpectokenDtos = primitiveSpectokenDriver.getOwnValidPrimitiveSpectokens();
            log.info(primitiveSpectokenDtos.size() + " valid primitive spectoken found.");
            for (PrimitiveSpectokenDto primitiveSpectokenDto : primitiveSpectokenDtos) {
                if (new Date().after(primitiveSpectokenDto.getEndDate())) {
                    primitiveSpectokenDriver.invalidatePrimitiveSpectoken(primitiveSpectokenDto.getLicenseId());
                    log.info("Primitive spectoken with license id " + primitiveSpectokenDto.getLicenseId() + " has been invalidated.");
                }
            }

            List<DerivativeSpectokenDto> derivativeSpectokenDtos = derivativeSpectokenDriver.getOwnValidDerivativeSpectokens();
            log.info(derivativeSpectokenDtos.size() + " valid derivative spectoken found.");
            for (DerivativeSpectokenDto derivativeSpectokenDto : derivativeSpectokenDtos) {
                if (new Date().after(derivativeSpectokenDto.getEndDate())) {
                    derivativeSpectokenDriver.invalidateDerivativeSpectoken(derivativeSpectokenDto.getId());
                    log.info("Derivative spectoken with id " + derivativeSpectokenDto.getId() + " has been invalidated.");
                }
            }

            List<ProductOrderDto> productOrderDtos = productOrderDriver.getOwnProductOrder();
            log.info(productOrderDtos.size() + " product order found.");
            for (ProductOrderDto productOrderDto : productOrderDtos) {
                if (new Date().after(productOrderDto.getEndDate())) {
                    Optional<OrderOfferMapping> optionalOrderOfferMapping = orderOfferMappingRepository.findByOrderDid(productOrderDto.getOrderDid());
                    if (!optionalOrderOfferMapping.isPresent()) {
                        throw new NoSuchElementException("Product Order not found in database (OrderOfferMapping).");
                    }
                    derivativeSpectokenDriver.redeemDerivativeSpectoken(optionalOrderOfferMapping.get().getOfferDid(), productOrderDto.getSeller(), true);
                }
            }

        } catch (ExecutionException | InterruptedException | NoSuchElementException | SpectokenException e) {
            log.error(e.getMessage());
        }

    }
}
