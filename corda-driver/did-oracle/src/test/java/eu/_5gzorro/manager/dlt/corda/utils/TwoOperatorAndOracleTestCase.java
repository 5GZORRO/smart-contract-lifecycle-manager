package eu._5gzorro.manager.dlt.corda.utils;

import net.corda.core.identity.CordaX500Name;
import net.corda.testing.node.StartedMockNode;
import org.junit.Before;

public class TwoOperatorAndOracleTestCase extends TwoOperatorTestCase {
  public StartedMockNode oracle;

  @Override
  @Before
  public void setup() {
    super.setup();

    oracle = network.createNode(CordaX500Name.parse("O=Oracle,L=London,C=GB"));
  }
}
