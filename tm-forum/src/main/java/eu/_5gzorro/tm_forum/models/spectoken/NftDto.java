package eu._5gzorro.tm_forum.models.spectoken;

public class NftDto {

    private final String id;

    private final String issuer;

    private final String tokenType;

    private final String tokenTypeId;

    public NftDto(String id, String issuer, String tokenType, String tokenTypeId) {
        this.id = id;
        this.issuer = issuer;
        this.tokenType = tokenType;
        this.tokenTypeId = tokenTypeId;
    }

    public String getId() {
        return id;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getTokenTypeId() {
        return tokenTypeId;
    }
}
