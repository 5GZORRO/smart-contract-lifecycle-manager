package eu._5gzorro;

import eu._5gzorro.lifecycle.manager.domain.Invitation;
import eu._5gzorro.lifecycle.manager.domain.ProductOffering;
import eu._5gzorro.lifecycle.manager.domain.VerifiableCredential;
import eu._5gzorro.lifecycle.manager.service.ProductOfferingDriver;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ProductOfferingDriverImpl implements ProductOfferingDriver {

  @Override
  public void publishProductOffering(
      ProductOffering offer,
      Map<String, Invitation> invitations,
      Collection<VerifiableCredential> verifiableCredentials,
      VerifiableCredential identityCredential) {
    // Stub
  }

  @Override
  public void updateProductOffer(ProductOffering offer, VerifiableCredential identityCredential) {
    // Stub
  }

  @Override
  public void removeProductOffer(String offerId, VerifiableCredential identityCredential) {
    // Stub
  }
}
