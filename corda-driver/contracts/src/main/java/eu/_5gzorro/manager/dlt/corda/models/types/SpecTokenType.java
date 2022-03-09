package eu._5gzorro.manager.dlt.corda.models.types;

import com.r3.corda.lib.tokens.contracts.states.EvolvableTokenType;
import eu._5gzorro.tm_forum.models.GeographicAddress;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SpecTokenType extends EvolvableTokenType {

    public static final int FRACTION_DIGITS = 0;

    @NotNull
    private final List<Party> maintainers;

    @NotNull
    private final UniqueIdentifier uniqueIdentifier;

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

    public SpecTokenType(
            @NotNull final List<Party> maintainers,
            @NotNull final UniqueIdentifier uniqueIdentifier,
            @NotNull final String did,
            @NotNull final Double startDl,
            @NotNull final Double endDl,
            @NotNull final Double startUl,
            @NotNull final Double endUl,
            @NotNull final Date startDate,
            @NotNull final Date endDate,
            @NotNull final String duplexMode,
            @NotNull final Integer band,
            @NotNull final String technology,
            @NotNull final GeographicAddress geographicAddress,
            final String ownerDid
    ) {
        this.maintainers = maintainers;
        this.uniqueIdentifier = uniqueIdentifier;
        this.did = did;
        this.startDl = startDl;
        this.endDl = endDl;
        this.startUl = startUl;
        this.endUl = endUl;
        this.startTime = startDate;
        this.endTime = endDate;
        this.duplexMode = duplexMode;
        this.band = band;
        this.technology = technology;
        this.geographicAddress = geographicAddress;
        this.ownerDid = ownerDid;
    }


    @Override
    public int getFractionDigits() {
        return FRACTION_DIGITS;
    }

    @NotNull
    @Override
    public List<Party> getMaintainers() {
        return maintainers;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return uniqueIdentifier;
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
    public Date getStartTime() {
        return startTime;
    }

    @NotNull
    public Date getEndTime() {
        return endTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecTokenType that = (SpecTokenType) o;
        return getMaintainers().equals(that.getMaintainers()) && uniqueIdentifier.equals(that.uniqueIdentifier) && getDid().equals(that.getDid()) && getStartDl().equals(that.getStartDl()) && getEndDl().equals(that.getEndDl()) && getStartUl().equals(that.getStartUl()) && getEndUl().equals(that.getEndUl()) && getStartTime().equals(that.getStartTime()) && getEndTime().equals(that.getEndTime()) && getDuplexMode().equals(that.getDuplexMode()) && getBand().equals(that.getBand()) && getTechnology().equals(that.getTechnology()) && getGeographicAddress().equals(that.getGeographicAddress()) && Objects.equals(getOwnerDid(), that.getOwnerDid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaintainers(), uniqueIdentifier, getDid(), getStartDl(), getEndDl(), getStartUl(), getEndUl(), getStartTime(), getEndTime(), getDuplexMode(), getBand(), getTechnology(), getGeographicAddress(), getOwnerDid());
    }
}
