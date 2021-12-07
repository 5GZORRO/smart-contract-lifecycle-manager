package eu._5gzorro.manager.api.httpClient;

import eu._5gzorro.manager.api.dto.identityPermisssions.StakeholderStatusDto;
import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="didClient", url = "${integrations.identity-permissions.myAgentBaseUrl}")
public interface DIDClient {

    @RequestMapping(method = RequestMethod.POST, value = "/holder/create_did")
    void create(@RequestBody CreateDidRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/holder/read_stakeholder_status")
    List<StakeholderStatusDto> getMyStakeholderCredential();
}
