package eu._5gzorro.service;

import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DIDToCordaDLTIdentityService implements DIDToDLTIdentityService {

  private final RestTemplate restTemplate = new RestTemplate();
  private final String identityBaseUrl;

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
