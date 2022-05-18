package eu._5gzorro.service;

import eu._5gzorro.manager.dlt.corda.service.product_order.CordaProductOrderDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DIDToCordaDLTIdentityService implements DIDToDLTIdentityService {

  private final RestTemplate restTemplate = new RestTemplate();
  private final String identityBaseUrl;

  private static final Logger log = LoggerFactory.getLogger(DIDToCordaDLTIdentityService.class);

  public DIDToCordaDLTIdentityService(String identityBaseUrl) {
    this.identityBaseUrl = identityBaseUrl;
  }

  @Override
  public String resolveIdentity(String did) {

    ResponseEntity<String> response =
        restTemplate.getForEntity(
            identityBaseUrl + "/holder/read_stakeholder?stakeholder_did=" + did, String.class);

    JSONParser jsonParser = new JSONParser();
    String ledgerIdentity = "";
    try {

      log.info("Stakeholder info: " + response.getBody());

      JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());
      jsonObject = (JSONObject) jsonObject.get("stakeholderClaim");
      jsonObject = (JSONObject) jsonObject.get("stakeholderProfile");
      ledgerIdentity = jsonObject.get("ledgerIdentity").toString();
    } catch (ParseException e) {
      ledgerIdentity = "ParseException";
    }
    return ledgerIdentity;
  }
}
