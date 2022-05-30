package eu._5gzorro.manager.service;


import javax.validation.constraints.NotNull;
import java.util.Date;

public interface DerivativeSpectokenDriver {

    /**
     * API Endpoint for a provider to create a new Spectoken to the DLT
     */
    void createDerivativeSpectoken(
            @NotNull final Double startDl,
            @NotNull final Double endDl,
            @NotNull final Double startUl,
            @NotNull final Double endUl,
            @NotNull final Date startDate,
            @NotNull final Date endDate,
            @NotNull final String duplexMode,
            @NotNull final Integer band,
            @NotNull final String technology,
            @NotNull final String country,
            final String ownerDid,
            @NotNull final String primitiveDid,
            final Float price
    );

}