package eu._5gzorro.manager.service;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOrderDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
import io.reactivex.rxjava3.core.Observable;

import java.util.Collection;
import java.util.Map;

public interface ProductOrderDriver {

  /**
   * API Endpoint for a provider to publish a new product offer to the DLT
   *
   * @param orderDetails TM Forum model capturing the product order specification
   * @param invitations Mapping of DID to Invitation Objects (see Identity Management) for any DIDs
   *     that may require credential verification
   * @param verifiableCredentials Optionally include applicable verifiable credentials for the
   *     offer. E.g., Spectrum rights VC required to successfully publish a spectrum offer
   * @param identityCredential is required for each call to identify the calling parties identity
   *     and ensure they have permission to perform action
   */
  void publishProductOrder(
      ProductOrderDetails orderDetails,
      Map<String, Invitation> invitations,
      Collection<VerifiableCredential> verifiableCredentials,
      VerifiableCredential identityCredential);

  void approveProductOrder(String orderId);

  void acceptChangeProposalProductOrder(String orderId);

  void endProductOrder(String orderId);

  void proposeChangeProductOrder(
      String orderId, ProductOrderDetails orderDetails, Map<String, Invitation> invitations);

  void provisionProductOrder(String orderId);

  void rejectChangeProductOrder(String orderId);

  void rejectProductOrder(String orderId, String rejectionReason);

  Observable<ProductOrderUpdateEvent> productOrderObservable();
}
