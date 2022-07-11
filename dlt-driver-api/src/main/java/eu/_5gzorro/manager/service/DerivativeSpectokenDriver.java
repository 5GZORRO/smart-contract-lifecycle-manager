package eu._5gzorro.manager.service;


import eu._5gzorro.manager.domain.ProductOfferDetails;

import javax.validation.constraints.NotNull;
import java.util.concurrent.ExecutionException;

public interface DerivativeSpectokenDriver {

    /**
     * API Endpoint for a provider to create a new Spectoken to the DLT
     */
    void issueDerivativeSpectoken(String offerDid, String ownerDid);

    boolean createDerivativeSpectokenFromOffer(@NotNull final ProductOfferDetails productOfferDetails, @NotNull String offerDid) throws ExecutionException, InterruptedException;

}
