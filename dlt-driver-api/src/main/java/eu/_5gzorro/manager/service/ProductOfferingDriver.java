package eu._5gzorro.manager.service;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOffering;
import eu._5gzorro.manager.domain.VerifiableCredential;
import io.reactivex.rxjava3.core.Observable;
import java.util.Collection;
import java.util.Map;

public interface ProductOfferingDriver {

  /**
   * API Endpoint for a provider to publish a new product offer to the DLT
   * @param offer TM Forum model capturing the product offering specification
   * @param invitations Mapping of DID to Invitation Objects (see Identity Management) for any DIDs that
   *                    may require credential verification
   * @param verifiableCredentials Optionally include applicable verifiable credentials for the offer.
   *                              E.g., Spectrum rights VC required to successfully publish a spectrum offer
   * @param identityCredential is required for each call to identify the calling parties identity and
   *                           ensure they have permission to perform action
   */
  void publishProductOffering(
      ProductOffering offer,
      Map<String, Invitation> invitations,
      Collection<VerifiableCredential> verifiableCredentials,
      VerifiableCredential identityCredential
  );

  /**
   * API Endpoint for a provider to update one of their product offerings on the DLT and subsequently be
   * announced to all marketplace trading stakeholders
   * @param offer TM Forum model capturing the product offering specification
   * @param identityCredential is required for each call to identify the calling parties identity and
   *                           ensure they have permission to perform action
   */
  void updateProductOffer(
      ProductOffering offer,
      VerifiableCredential identityCredential
  );

  /**
   * API Endpoint for a provider to retire a product offering from the marketplace
   * catalogue by marking it as such on the DLT
   * @param offerId DID of the product offering
   * @param identityCredential is required for each call to identify the calling parties identity and
   *                           ensure they have permission to perform action
   */
  void removeProductOffer(
      String offerId,
      VerifiableCredential identityCredential
  );

  Observable<ProductOffering> productOfferObservable();
}
