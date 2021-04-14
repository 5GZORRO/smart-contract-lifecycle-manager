package eu._5gzorro.manager.dlt.corda.utils.serialization;

import net.corda.core.internal.ToggleField;
import net.corda.core.serialization.internal.SerializationEnvironment;
import net.corda.core.serialization.internal.SerializationEnvironmentKt;
import net.corda.testing.internal.InternalSerializationTestHelpersKt;

import java.util.List;

import static kotlin.collections.CollectionsKt.listOf;

public class SerializationEnvUtil {
  private static final List<ToggleField<SerializationEnvironment>> serializationEnvFields =
      listOf(
          SerializationEnvironmentKt.get_driverSerializationEnv(),
          SerializationEnvironmentKt.get_contextSerializationEnv(),
          SerializationEnvironmentKt.get_inheritableContextSerializationEnv(),
          SerializationEnvironmentKt.get_rpcClientSerializationEnv());

  public static void clearEnv() {
    serializationEnvFields.forEach(
        toggleField -> {
          if (toggleField.get() != null) toggleField.set(null);
        });
    InternalSerializationTestHelpersKt.getInVMExecutors().clear();
  }
}
