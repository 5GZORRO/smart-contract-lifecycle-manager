package eu._5gzorro.manager.service;


import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.tm_forum.models.spectoken.GetDerivativeSpectokenResponse;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DerivativeSpectokenDriver {

    /**
     * API Endpoint for a provider to create a new Spectoken to the DLT
     */
    boolean issueDerivativeSpectoken(String offerDid, String ownerDid) throws ExecutionException, InterruptedException;

    boolean issueDerivativeSpectoken(String offerDid) throws ExecutionException, InterruptedException;

    boolean createDerivativeSpectokenFromOffer(@NotNull final ProductOfferDetails productOfferDetails, @NotNull String offerDid) throws ExecutionException, InterruptedException;

    List<GetDerivativeSpectokenResponse> getDerivativeSpectokens() throws ExecutionException, InterruptedException;

    boolean redeemDerivativeSpectoken(String offerDid, String sellerName) throws ExecutionException, InterruptedException;

}
