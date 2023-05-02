package eu._5gzorro.manager.service;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.exception.SpectokenException;
import io.reactivex.rxjava3.core.Observable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ProductOfferingDriver {

    /**
     * API Endpoint for a provider to publish a new product offer to the DLT
     *
     * @param offerDetails          TM Forum model capturing the product offering specification
     * @param invitations           Mapping of DID to Invitation Objects (see Identity Management) for any DIDs that
     *                              may require credential verification
     * @param verifiableCredentials Optionally include applicable verifiable credentials for the offer.
     *                              E.g., Spectrum rights VC required to successfully publish a spectrum offer
     * @param identityCredential    is required for each call to identify the calling parties identity and
     *                              ensure they have permission to perform action
     */
    void publishProductOffering(
        ProductOfferDetails offerDetails,
        Map<String, Invitation> invitations,
        Collection<VerifiableCredential> verifiableCredentials,
        VerifiableCredential identityCredential,
        String did
    ) throws ExecutionException, InterruptedException, SpectokenException;

    /**
     * API Endpoint for a provider to update one of their product offerings on the DLT and subsequently be
     * announced to all marketplace trading stakeholders
     *
     * @param offerDetails       TM Forum model capturing the product offering specification
     * @param identityCredential is required for each call to identify the calling parties identity and
     *                           ensure they have permission to perform action
     */
    void updateProductOffer(
        ProductOfferDetails offerDetails,
        VerifiableCredential identityCredential
    );

    /**
     * API Endpoint for a provider to retire a product offering from the marketplace
     * catalogue by marking it as such on the DLT
     *
     * @param offerId            DID of the product offering
     * @param identityCredential is required for each call to identify the calling parties identity and
     *                           ensure they have permission to perform action
     */
    void removeProductOffer(String offerId);

    Observable<ProductOfferingUpdateEvent> productOfferObservable();
}
