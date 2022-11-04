package eu._5gzorro.manager.service;

import eu._5gzorro.tm_forum.models.spectoken.GetPrimitiveSpectokenResponse;
import eu._5gzorro.tm_forum.models.spectoken.NftResponse;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PrimitiveSpectokenDriver {

    /**
     * API Endpoint for a provider to create a new Spectoken to the DLT
     */
    void createPrimitiveSpectoken(
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
        @NotNull final String license
    ) throws ExecutionException, InterruptedException;

    List<GetPrimitiveSpectokenResponse> getPrimitiveSpectokens() throws ExecutionException, InterruptedException;

    List<String> invalidatePrimitiveSpectoken(String licenseId) throws ExecutionException, InterruptedException;

    List<NftResponse> getNfts()  throws ExecutionException, InterruptedException;
}
