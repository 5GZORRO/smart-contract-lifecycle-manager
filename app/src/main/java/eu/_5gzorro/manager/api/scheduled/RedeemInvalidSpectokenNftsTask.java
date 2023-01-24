package eu._5gzorro.manager.api.scheduled;

import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.manager.service.SpectokenNftDriver;
import eu._5gzorro.tm_forum.models.spectoken.DerivativeSpectokenDto;
import eu._5gzorro.tm_forum.models.spectoken.NftDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Configuration
@EnableScheduling
public class RedeemInvalidSpectokenNftsTask {

    private static final Logger log = LoggerFactory.getLogger(RedeemInvalidSpectokenNftsTask.class);

    private final DerivativeSpectokenDriver derivativeSpectokenDriver;
    private final PrimitiveSpectokenDriver primitiveSpectokenDriver;
    private final SpectokenNftDriver spectokenNftDriver;

    public RedeemInvalidSpectokenNftsTask(DerivativeSpectokenDriver derivativeSpectokenDriver, PrimitiveSpectokenDriver primitiveSpectokenDriver, SpectokenNftDriver spectokenNftDriver) {
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
        this.primitiveSpectokenDriver = primitiveSpectokenDriver;
        this.spectokenNftDriver = spectokenNftDriver;
    }

    @Scheduled(cron = "${cron.schedule.nfts}")
    public void execute() {

        try {
            List<NftDto> nftDtos = spectokenNftDriver.getNftDtos();
            log.info(nftDtos.size() + " Spectoken NFTs found.");
            for (NftDto nftDto : nftDtos) {
                boolean redeemed = false;
                if ("PrimitiveSpecTokenType".equals(nftDto.getTokenType())) {
                    if (!primitiveSpectokenDriver.isPrimitiveSpectokenValid(nftDto.getTokenTypeId())) {
                        redeemed = primitiveSpectokenDriver.redeemPrimitiveSpectoken(nftDto.getTokenTypeId(), nftDto.getIssuer());
                    }
                } else if ("DerivativeSpecTokenType".equals(nftDto.getTokenType())) {
                    DerivativeSpectokenDto derivativeSpectokenDto = derivativeSpectokenDriver.getDerivativeSpectokenDto(nftDto.getTokenTypeId());
                    if (!derivativeSpectokenDto.isValid()) {
                        redeemed = derivativeSpectokenDriver.redeemDerivativeSpectoken(derivativeSpectokenDto.getOfferDid(), nftDto.getIssuer(), false, derivativeSpectokenDto.getId());
                    }
                } else {
                    log.error(nftDto.getTokenType() + " not found.");
                }
                if (redeemed) {
                    log.info("NFT with id: " + nftDto.getId() + " redeemed.");
                }
            }
        } catch (ExecutionException | InterruptedException | SpectokenException e) {
            log.error(e.getMessage());
        }

    }
}
