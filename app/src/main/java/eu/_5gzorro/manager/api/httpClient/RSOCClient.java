package eu._5gzorro.manager.api.httpClient;

import eu._5gzorro.manager.api.httpClient.responses.ProductOfferingStatus;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(value = "RSOCClient")
public interface RSOCClient {

    @GetMapping
    ProductOffering getPoById(URI endpoint);

    @GetMapping
    ProductOfferingPrice getPopById(URI endpoint);

    @GetMapping
    ProductOfferingStatus getPoDID(URI endpoint);
}
