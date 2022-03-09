package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.models.types.PrimitiveSpecTokenType;
import eu._5gzorro.tm_forum.models.GeographicAddress;
import net.corda.core.contracts.TransactionState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class IssuePrimitiveSpecTokenTypeFlow extends FlowLogic<SignedTransaction> {

    @NotNull
    private final Party notary;

    @NotNull
    private final List<Party> observers;

    @NotNull
    private final String did;

    @NotNull
    private final Double startDl;

    @NotNull
    private final Double endDl;

    @NotNull
    private final Double startUl;

    @NotNull
    private final Double endUl;

    @NotNull
    private final Date startTime;

    @NotNull
    private final Date endTime;

    @NotNull
    private final String duplexMode;

    @NotNull
    private final Integer band;

    @NotNull
    private final String technology;


    @NotNull
    private final GeographicAddress geographicAddress;

    private final String ownerDid;

    public IssuePrimitiveSpecTokenTypeFlow(
            @NotNull Party notary,
            @NotNull List<Party> observers,
            @NotNull String did,
            @NotNull Double startDl,
            @NotNull Double endDl,
            @NotNull Double startUl,
            @NotNull Double endUl,
            @NotNull Date startTime,
            @NotNull Date endTime,
            @NotNull String duplexMode,
            @NotNull Integer band,
            @NotNull String technology,
            @NotNull GeographicAddress geographicAddress,
            String ownerDid
    ) {
        this.notary = notary;
        this.observers = observers;
        this.did = did;
        this.startDl = startDl;
        this.endDl = endDl;
        this.startUl = startUl;
        this.endUl = endUl;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duplexMode = duplexMode;
        this.band = band;
        this.technology = technology;
        this.geographicAddress = geographicAddress;
        this.ownerDid = ownerDid;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        final Party nodeIdentity = getOurIdentity();
        if (!nodeIdentity.getName().equals("TODO")) {
            throw new FlowException("We are incorrect node");
        }
        final PrimitiveSpecTokenType newSpectoken = new PrimitiveSpecTokenType(
                Collections.singletonList(nodeIdentity),
                new UniqueIdentifier(),
                did,
                startDl,
                endDl,
                startUl,
                endUl,
                startTime,
                endTime,
                duplexMode,
                band,
                technology,
                geographicAddress,
                ownerDid);
        final TransactionState<PrimitiveSpecTokenType> transactionState = new TransactionState<>(newSpectoken, notary);
        return subFlow(new CreateEvolvableTokens(transactionState, observers));
    }
}
