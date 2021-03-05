package eu._5gzorro.manager.dlt.corda.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "corda.rpc")
public class DriverConfigurationProperties {
  private String host;
  private int rpcPort;
  private String username;
  private String password;

  public String getHost() {
    return host;
  }

  public DriverConfigurationProperties setHost(String host) {
    this.host = host;
    return this;
  }

  public int getRpcPort() {
    return rpcPort;
  }

  public DriverConfigurationProperties setRpcPort(int rpcPort) {
    this.rpcPort = rpcPort;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public DriverConfigurationProperties setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public DriverConfigurationProperties setPassword(String password) {
    this.password = password;
    return this;
  }
}
