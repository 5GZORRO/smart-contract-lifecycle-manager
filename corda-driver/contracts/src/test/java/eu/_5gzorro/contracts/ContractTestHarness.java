package eu._5gzorro.contracts;

import static net.corda.testing.node.internal.InternalTestUtilsKt.setDriverSerialization;

import java.util.Collections;
import net.corda.core.identity.CordaX500Name;
import net.corda.testing.core.TestIdentity;
import net.corda.testing.node.MockServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ContractTestHarness {

  protected final TestIdentity megaCorp = new TestIdentity(new CordaX500Name("MegaCorp", "London", "GB"));
  protected final TestIdentity governor = new TestIdentity(new CordaX500Name("Governor", "London", "GB"));
  protected final MockServices ledgerServices = new MockServices(Collections.singleton("eu._5gzorro.contracts"));

  @BeforeAll
  public void setup() {
    // need this to reload corda's serialization whitelist see: https://github.com/corda/corda/issues/6227
    // applicable due to whitelist class: eu._5gzorro.whitelist.ExtendedSerializationWhitelist
    setDriverSerialization(ClassLoader.getSystemClassLoader());
  }
}
