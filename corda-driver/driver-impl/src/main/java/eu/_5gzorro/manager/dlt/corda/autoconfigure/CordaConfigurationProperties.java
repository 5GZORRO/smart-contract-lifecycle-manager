package eu._5gzorro.manager.dlt.corda.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "corda")
public class CordaConfigurationProperties {
  private List<String> governanceNodeNames;
  private List<String> regulatorNodeNames;
  private DriverConfigurationProperties rpc;
  private String identityBaseUrl;

  public List<String> getGovernanceNodeNames() {
    return governanceNodeNames;
  }

  public List<String> getRegulatorNodeNames() {
    return regulatorNodeNames;
  }

  public CordaConfigurationProperties setGovernanceNodeNames(
      List<String> governanceNodeNames) {
    this.governanceNodeNames = governanceNodeNames;
    return this;
  }

  public CordaConfigurationProperties setRegulatorNodeNames(List<String> regulatorNodeNames) {
    this.regulatorNodeNames = regulatorNodeNames;
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

  public String getIdentityBaseUrl() {
    return identityBaseUrl;
  }

  public CordaConfigurationProperties setIdentityBaseUrl(String identityBaseUrl) {
    this.identityBaseUrl = identityBaseUrl;
    return this;
  }
}
