package eu._5gzorro.manager.dlt.corda.oracle.service;

import net.corda.core.crypto.TransactionSignature;
import net.corda.core.identity.Party;
import net.corda.core.node.AppServiceHub;
import net.corda.core.node.services.CordaService;
import net.corda.core.serialization.SingletonSerializeAsToken;
import net.corda.core.transactions.ComponentVisibilityException;
import net.corda.core.transactions.FilteredTransaction;
import net.corda.core.transactions.FilteredTransactionVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PublicKey;

/*
    TODO Skeleton of checks oracle needs to perform, remove this module if no oracle needed
 */
@CordaService
public class Oracle extends SingletonSerializeAsToken {

  private static final Logger log = LoggerFactory.getLogger(Oracle.class);
  private final AppServiceHub services;
  private final PublicKey myKey;

  public Oracle(AppServiceHub services) {
    this.services = services;
    this.myKey = services.getMyInfo().getLegalIdentities().get(0).getOwningKey();
  }

  public TransactionSignature sign(FilteredTransaction ftx, Party requester)
      throws FilteredTransactionVerificationException {
    // Check the partial Merkle tree is valid.
    ftx.verify();

    // Is it a Merkle tree we are willing to sign over?
    boolean isValidMerkleTree = ftx
        .checkWithFun(elem -> this.verify(elem, requester));

    try {
      /**
       * Function that checks if all of the commands that should be signed by the input public key are visible.
       * This functionality is required from Oracles to check that all of the commands they should sign are visible.
       */
      ftx.checkCommandVisibility(services.getMyInfo().getLegalIdentities().get(0).getOwningKey());
    } catch (ComponentVisibilityException e) {
      e.printStackTrace();
    }

    if (isValidMerkleTree) {
      return services.createSignature(ftx, myKey);
    } else {
      throw new IllegalArgumentException("Oracle signature requested over invalid transaction.");
    }
  }

  public Oracle(AppServiceHub services, PublicKey myKey) {
    this.services = services;
    this.myKey = myKey;
  }

  private boolean verify(Object elem, Party requester) {

    // TODO perform checks needed for this oracle
    return false;
  }
}
