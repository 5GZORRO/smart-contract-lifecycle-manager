package eu._5gzorro.manager.service;


import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.tm_forum.models.spectoken.DerivativeSpectokenDto;
import eu._5gzorro.tm_forum.models.spectoken.GetDerivativeSpectokenResponse;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DerivativeSpectokenDriver {

    boolean issueDerivativeSpectoken(String offerDid, String ownerDid) throws ExecutionException, InterruptedException, SpectokenException;

    boolean issueDerivativeSpectoken(String offerDid) throws ExecutionException, InterruptedException, SpectokenException;

    boolean createDerivativeSpectokenFromOffer(@NotNull final ProductOfferDetails productOfferDetails, @NotNull String offerDid) throws ExecutionException, InterruptedException;

    List<GetDerivativeSpectokenResponse> getDerivativeSpectokens() throws ExecutionException, InterruptedException;

    boolean redeemDerivativeSpectoken(String offerDid, String sellerName, boolean needIssuedUpdate, String derivativeId) throws ExecutionException, InterruptedException, SpectokenException;

    DerivativeSpectokenDto getDerivativeSpectokenDto(String id);

    boolean invalidateDerivativeSpectoken(String id) throws ExecutionException, InterruptedException;

    List<DerivativeSpectokenDto> getOwnValidDerivativeSpectokens();
}
