package eu._5gzorro.tm_forum.models.spectoken;

public class DerivativeSpectokenDto {

    private final boolean valid;
    private final String offerDid;

    public DerivativeSpectokenDto(boolean valid, String offerDid) {
        this.valid = valid;
        this.offerDid = offerDid;
    }

    public boolean isValid() {
        return valid;
    }

    public String getOfferDid() {
        return offerDid;
    }
}
