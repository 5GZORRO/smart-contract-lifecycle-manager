package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.api.httpClient.DIDClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityAndPermissionsApiClientImpl implements IdentityAndPermissionsApiClient {

    @Autowired
    private DIDClient didClient;

    @Override
    public void createDID(String handlerUrl, String authToken) {
        didClient.create(handlerUrl, authToken);
    }
}
