package eu._5gzorro.manager.api.dto.identityPermisssions;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

public class StakeholderRoleDto {

    @NotBlank
    private String role;
    private List<String> assets; //TODO: ENUM when available

    public StakeholderRoleDto() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderRoleDto that = (StakeholderRoleDto) o;
        return role.equals(that.role) && Objects.equals(assets, that.assets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, assets);
    }

    @Override
    public String toString() {
        return "StakeholderRole{" +
                "role='" + role + '\'' +
                ", assets=" + assets +
                '}';
    }
}
