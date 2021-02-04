package eu._5gzorro.contracts;

import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

public class EstablishAgreementContract implements Contract {
  public static final String ID = "eu._5gzorro.contracts.EstablishAgreementContract";

  public interface CommandType extends CommandData {
    class Propose implements CommandType {}
    class Agree implements CommandType {}
  }

  @Override
  public void verify(@NotNull LedgerTransaction tx) {

  }
}
