package eu._5gzorro.manager.service;

import eu._5gzorro.tm_forum.models.GeographicAddress;

import javax.validation.constraints.NotNull;
import java.util.Date;

public interface PrimitiveSpectokenDriver {

    /**
     * API Endpoint for a provider to create a new product Spectoken to the DLT
     */
    void createPrimitiveSpectoken(
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
    );

}
