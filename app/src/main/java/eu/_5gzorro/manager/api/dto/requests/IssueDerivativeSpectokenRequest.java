package eu._5gzorro.manager.api.dto.requests;

import org.jetbrains.annotations.NotNull;

public class IssueDerivativeSpectokenRequest {

    @NotNull
    private final String offerDid;

    @NotNull
    private final String ownerDid;

    public IssueDerivativeSpectokenRequest(@NotNull String offerDid, @NotNull String ownerDid) {
        this.offerDid = offerDid;
        this.ownerDid = ownerDid;
    }

    @NotNull
    public String getOfferDid() {
        return offerDid;
    }

    @NotNull
    public String getOwnerDid() {
        return ownerDid;
    }

}
