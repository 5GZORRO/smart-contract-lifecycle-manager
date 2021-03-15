package eu._5gzorro.manager.dlt.corda.autoconfigure;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "corda")
public class CordaConfigurationProperties {
  private List<String> governanceNodeNames;
  private DriverConfigurationProperties rpc;

  public List<String> getGovernanceNodeNames() {
    return governanceNodeNames;
  }

  public CordaConfigurationProperties setGovernanceNodeNames(
      List<String> governanceNodeNames) {
    this.governanceNodeNames = governanceNodeNames;
    return this;
  }

  public DriverConfigurationProperties getRpc() {
    return rpc;
  }

  public CordaConfigurationProperties setRpc(
      DriverConfigurationProperties rpc) {
    this.rpc = rpc;
    return this;
  }
}
