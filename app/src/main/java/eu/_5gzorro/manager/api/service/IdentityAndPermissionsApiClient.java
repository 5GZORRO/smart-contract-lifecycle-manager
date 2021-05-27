package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;

public interface IdentityAndPermissionsApiClient {
    void createDID(CreateDidRequest request);
}
