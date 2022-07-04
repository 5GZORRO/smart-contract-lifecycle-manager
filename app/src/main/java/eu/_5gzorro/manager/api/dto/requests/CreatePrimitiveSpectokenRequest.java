package eu._5gzorro.manager.api.dto.requests;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class CreatePrimitiveSpectokenRequest {

    @NotNull
    private final Double startDl;

    @NotNull
    private final Double endDl;

    @NotNull
    private final Double startUl;

    @NotNull
    private final Double endUl;

    @NotNull
    private final Date startDate;

    @NotNull
    private final Date endDate;

    @NotNull
    private final String duplexMode;

    @NotNull
    private final Integer band;

    @NotNull
    private final String technology;

    @NotNull
    private final String country;

    private final String ownerDid;

    @NotNull
    private final String license;

    public CreatePrimitiveSpectokenRequest(@NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull String country, String ownerDid, @NotNull String license) {
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

    @NotNull
    public Double getStartDl() {
        return startDl;
    }

    @NotNull
    public Double getEndDl() {
        return endDl;
    }

    @NotNull
    public Double getStartUl() {
        return startUl;
    }

    @NotNull
    public Double getEndUl() {
        return endUl;
    }

    @NotNull
    public Date getStartDate() {
        return startDate;
    }

    @NotNull
    public Date getEndDate() {
        return endDate;
    }

    @NotNull
    public String getDuplexMode() {
        return duplexMode;
    }

    @NotNull
    public Integer getBand() {
        return band;
    }

    @NotNull
    public String getTechnology() {
        return technology;
    }

    @NotNull
    public String getCountry() {
        return country;
    }

    public String getOwnerDid() {
        return ownerDid;
    }

    @NotNull
    public String getLicense() {
        return license;
    }

}
