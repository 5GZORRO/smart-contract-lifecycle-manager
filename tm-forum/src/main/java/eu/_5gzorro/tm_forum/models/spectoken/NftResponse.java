package eu._5gzorro.tm_forum.models.spectoken;

public class NftResponse {

    private final String id;

    private final String issuer;

    private final String holder;

    private final String tokenType;

    public NftResponse(String id, String issuer, String holder, String tokenType) {
        this.id = id;
        this.issuer = issuer;
        this.holder = holder;
        this.tokenType = tokenType;
    }

    public String getId() {
        return id;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getHolder() {
        return holder;
    }

    public String getTokenType() {
        return tokenType;
    }

}
