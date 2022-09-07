package eu._5gzorro.tm_forum.models.spectoken;

import java.util.Date;

public class GetPrimitiveSpectokenResponse {

    private final String id;

    private final Double startDl;

    private final Double endDl;

    private final Double startUl;

    private final Double endUl;

    private final Date startDate;

    private final Date endDate;

    private final String duplexMode;

    private final Integer band;

    private final String technology;

    private final String country;

    private final String ownerDid;

    private final String license;

    public GetPrimitiveSpectokenResponse(String id, Double startDl, Double endDl, Double startUl, Double endUl, Date startDate, Date endDate, String duplexMode, Integer band, String technology, String country, String ownerDid, String license) {
        this.id = id;
        this.startDl = startDl;
        this.endDl = endDl;
        this.startUl = startUl;
        this.endUl = endUl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duplexMode = duplexMode;
        this.band = band;
        this.technology = technology;
        this.country = country;
        this.ownerDid = ownerDid;
        this.license = license;
    }

    public String getId() {
        return id;
    }

    public Double getStartDl() {
        return startDl;
    }

    public Double getEndDl() {
        return endDl;
    }

    public Double getStartUl() {
        return startUl;
    }

    public Double getEndUl() {
        return endUl;
    }


    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDuplexMode() {
        return duplexMode;
    }

    public Integer getBand() {
        return band;
    }

    public String getTechnology() {
        return technology;
    }

    public String getCountry() {
        return country;
    }

    public String getOwnerDid() {
        return ownerDid;
    }

    public String getLicense() {
        return license;
    }

}
