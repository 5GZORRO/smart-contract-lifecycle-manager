package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.api.dto.identityPermisssions.StakeholderStatusDto;
import eu._5gzorro.manager.api.httpClient.DIDClient;
import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityAndPermissionsApiClientImpl implements IdentityAndPermissionsApiClient {

    @Autowired
    private DIDClient didClient;

    private StakeholderStatusDto myStakeholderStatus;

    public IdentityAndPermissionsApiClientImpl() {}

    @Override
    public void createDID(CreateDidRequest request) {
        request.authToken(getAuthToken());
        didClient.create(request);
    }

    private String getAuthToken() {
        return didClient.getMyStakeholderCredential().get(0).getAuthToken();
    }
}
