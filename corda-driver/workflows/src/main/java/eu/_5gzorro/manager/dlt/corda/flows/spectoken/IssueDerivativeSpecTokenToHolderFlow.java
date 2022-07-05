package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

@InitiatingFlow
@StartableByRPC
public class IssueDerivativeSpecTokenToHolderFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String offerDid;
    private final Party issuer;
    private final AbstractParty holder;

    public IssueDerivativeSpecTokenToHolderFlow(String offerDid, Party issuer, AbstractParty holder) {
        this.offerDid = offerDid;
        this.issuer = issuer;
        this.holder = holder;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
//        QueryCriteria.VaultQueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL);
//        FieldInfo offerDidAttribute = new FieldInfo("offerDid", DerivativeSpecTokenType.class);
//        criteria.
//        Builder.equal(offerDidAttribute, offerDid);
//        PrimitiveSpecTokenType primitiveSpecTokenType = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class, criteria).getStates().get(0).getState().getData();
//        final TokenPointer<DerivativeSpecTokenType> derivativeSpecTokenTypeTokenPointer = derivativeSpecTokenType.toPointer(DerivativeSpecTokenType.class);
//        final IssuedTokenType issuedDerivativeSpectoken = new IssuedTokenType(issuer, derivativeSpecTokenTypeTokenPointer);
//        final NonFungibleToken derivativeSpectokenNft = new NonFungibleToken(issuedDerivativeSpectoken, holder, new UniqueIdentifier(), TransactionUtilitiesKt.getAttachmentIdForGenericParam(derivativeSpecTokenTypeTokenPointer));
//        return subFlow(new IssueTokens(Collections.singletonList(derivativeSpectokenNft)));
        return null;
    }
}
