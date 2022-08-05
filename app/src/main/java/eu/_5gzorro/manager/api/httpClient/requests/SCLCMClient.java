package eu._5gzorro.manager.api.httpClient.requests;

import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(value = "SCLCMClient")
public interface SCLCMClient {

    @GetMapping
    ServiceLevelAgreement getSLAById(URI endpoint);

    @GetMapping
    LicenseTerm getLicenseTermById(URI endpoint);
}
