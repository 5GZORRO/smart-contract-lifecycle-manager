package eu._5gzorro.service;

import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DIDToCordaDLTIdentityService implements DIDToDLTIdentityService {

  private final RestTemplate restTemplate = new RestTemplate();
  private final String governanceBaseUrl;

  public DIDToCordaDLTIdentityService(String governanceBaseUrl) {
    this.governanceBaseUrl = governanceBaseUrl;
  }

  @Override
  public String resolveIdentity(String did) {

    ResponseEntity<String> response =
        restTemplate.getForEntity(
            governanceBaseUrl + "/members/" + did + "/ledger-identity", String.class);

    return response.getBody();
  }
}
