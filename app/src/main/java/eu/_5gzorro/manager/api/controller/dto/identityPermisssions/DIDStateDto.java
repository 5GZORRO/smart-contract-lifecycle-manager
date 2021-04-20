package eu._5gzorro.manager.api.controller.dto.identityPermisssions;

import java.util.Objects;

public class DIDStateDto {
    private String did;
//    private DIDStateEnum state;
    private String state;

    public DIDStateDto() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

//    public DIDStateEnum getState() {
//        return state;
//    }
//
//    public void setState(DIDStateEnum state) {
//        this.state = state;
//    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DIDStateDto that = (DIDStateDto) o;
        return did.equals(that.did) && state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, state);
    }

    @Override
    public String toString() {
        return "DIDStateDto{" +
                "did='" + did + '\'' +
                ", state=" + state +
                '}';
    }
}
