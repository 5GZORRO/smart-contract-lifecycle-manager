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

    public IdentityAndPermissionsApiClientImpl() {
        this.myStakeholderStatus = didClient.getMyStakeholderCredential();
    }

    @Override
    public void createDID(CreateDidRequest request) {
        request.authToken(myStakeholderStatus.getAuthToken());
        didClient.create(request);
    }
}
