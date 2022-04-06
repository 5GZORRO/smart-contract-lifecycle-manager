package eu._5gzorro.manager.api.dto.requests;

import eu._5gzorro.tm_forum.models.GeographicAddress;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class CreatePrimitiveSpectokenRequest {

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
    private final GeographicAddress geographicAddress;

    private final String ownerDid;

    public CreatePrimitiveSpectokenRequest(@NotNull String did, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull GeographicAddress geographicAddress, String ownerDid) {
        this.did = did;
        this.startDl = startDl;
        this.endDl = endDl;
        this.startUl = startUl;
        this.endUl = endUl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duplexMode = duplexMode;
        this.band = band;
        this.technology = technology;
        this.geographicAddress = geographicAddress;
        this.ownerDid = ownerDid;
    }

    @NotNull
    public String getDid() {
        return did;
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
    public GeographicAddress getGeographicAddress() {
        return geographicAddress;
    }

    public String getOwnerDid() {
        return ownerDid;
    }

}
