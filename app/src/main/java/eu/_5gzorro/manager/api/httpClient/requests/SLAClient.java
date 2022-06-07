package eu._5gzorro.manager.api.httpClient.requests;

import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(value = "SLAClient")
public interface SLAClient {
    @GetMapping
    ServiceLevelAgreement getSLAById(URI endpoint);
}
