package eu._5gzorro.manager.dlt.corda.service.spectoken;

import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.service.SpectokenNftDriver;
import eu._5gzorro.tm_forum.models.spectoken.NftDto;
import eu._5gzorro.tm_forum.models.spectoken.NftResponse;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.services.Vault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CordaSpectokenNftDriver extends RPCSyncService<NonFungibleToken> implements SpectokenNftDriver {
    private final CordaRPCOps rpcClient;

    private static final Logger log = LoggerFactory.getLogger(CordaSpectokenNftDriver.class);

    public CordaSpectokenNftDriver(NodeRPC nodeRPC) {
        super(nodeRPC, NonFungibleToken.class);
        this.rpcClient = nodeRPC.getClient();
        setup();
    }

    @Override
    public List<NftResponse> getNftResponses() {
        Vault.Page<NonFungibleToken> nonFungibleTokenPage = rpcClient.vaultQuery(NonFungibleToken.class);
        List<NftResponse> nfts = new ArrayList<>();
        for (StateAndRef<NonFungibleToken> nonFungibleToken : nonFungibleTokenPage.getStates()) {
            nfts.add(convertToNftResponse(nonFungibleToken.getState().getData()));
        }
        return nfts;
    }

    @Override
    public List<NftDto> getNftDtos() {
        Vault.Page<NonFungibleToken> nonFungibleTokenPage = rpcClient.vaultQuery(NonFungibleToken.class);
        List<NftDto> nfts = new ArrayList<>();
        for (StateAndRef<NonFungibleToken> nonFungibleToken : nonFungibleTokenPage.getStates()) {
            nfts.add(convertToNftDto(nonFungibleToken.getState().getData()));
        }
        return nfts;
    }


    private NftResponse convertToNftResponse(NonFungibleToken nonFungibleToken) {
        return new NftResponse(
            nonFungibleToken.getLinearId().toString(),
            nonFungibleToken.getIssuer().getName().getOrganisation(),
            nonFungibleToken.getHolder().nameOrNull().getOrganisation(),
            nonFungibleToken.getToken().getTokenType().getTokenClass().getSimpleName() + " - " + nonFungibleToken.getToken().getTokenIdentifier()
        );
    }

    private NftDto convertToNftDto(NonFungibleToken nonFungibleToken) {
        return new NftDto(
            nonFungibleToken.getLinearId().toString(),
            nonFungibleToken.getIssuer().getName().toString(),
            nonFungibleToken.getToken().getTokenType().getTokenClass().getSimpleName(),
            nonFungibleToken.getToken().getTokenIdentifier()
        );
    }

    @Override
    public void setup() {

    }

}
