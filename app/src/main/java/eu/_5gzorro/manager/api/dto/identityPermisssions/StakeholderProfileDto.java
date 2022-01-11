package eu._5gzorro.manager.api.dto.identityPermisssions;

import eu._5gzorro.manager.api.model.NotificationMethodBase;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class StakeholderProfileDto {

    @NotBlank
    private String name;
    @NotBlank
    private String ledgerIdentity;
    private String address;

    @NotNull
    @Valid
    private NotificationMethodBase notificationMethod;

    public StakeholderProfileDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLedgerIdentity() {
        return ledgerIdentity;
    }

    public void setLedgerIdentity(String ledgerIdentity) {
        this.ledgerIdentity = ledgerIdentity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public NotificationMethodBase getNotificationMethod() {
        return notificationMethod;
    }

    public void setNotificationMethod(NotificationMethodBase notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderProfileDto that = (StakeholderProfileDto) o;
        return name.equals(that.name) && ledgerIdentity.equals(that.ledgerIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ledgerIdentity);
    }

    @Override
    public String toString() {
        return "StakeholderProfileDto{" +
                "name='" + name + '\'' +
                ", ledgerIdentity='" + ledgerIdentity + '\'' +
                ", address='" + address + '\'' +
                ", notificationMethod=" + notificationMethod +
                '}';
    }
}
