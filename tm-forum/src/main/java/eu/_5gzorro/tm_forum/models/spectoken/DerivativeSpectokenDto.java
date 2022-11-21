package eu._5gzorro.tm_forum.models.spectoken;

import java.util.Date;

public class DerivativeSpectokenDto {

    private final boolean valid;
    private final String offerDid;
    private final String id;
    private final Date endDate;

    public DerivativeSpectokenDto(boolean valid, String offerDid, String id, Date endDate) {
        this.valid = valid;
        this.offerDid = offerDid;
        this.id = id;
        this.endDate = endDate;
    }

    public boolean isValid() {
        return valid;
    }

    public String getOfferDid() {
        return offerDid;
    }

    public String getId() {
        return id;
    }

    public Date getEndDate() {
        return endDate;
    }

}
