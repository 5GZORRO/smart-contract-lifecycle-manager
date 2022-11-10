package eu._5gzorro.manager.service;

import eu._5gzorro.tm_forum.models.spectoken.GetPrimitiveSpectokenResponse;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PrimitiveSpectokenDriver {

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

    boolean redeemPrimitiveSpectoken(String id, String issuerName) throws ExecutionException, InterruptedException;

    boolean isPrimitiveSpectokenValid(String tokenTypeId);
}
