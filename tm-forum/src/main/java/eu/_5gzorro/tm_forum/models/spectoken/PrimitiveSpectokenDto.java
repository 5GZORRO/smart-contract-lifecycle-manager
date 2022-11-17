package eu._5gzorro.tm_forum.models.spectoken;

import java.util.Date;

public class PrimitiveSpectokenDto {

    private final Date endDate;
    private final String licenseId;

    public PrimitiveSpectokenDto(Date endDate, String licenseId) {
        this.endDate = endDate;
        this.licenseId = licenseId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLicenseId() {
        return licenseId;
    }
}
