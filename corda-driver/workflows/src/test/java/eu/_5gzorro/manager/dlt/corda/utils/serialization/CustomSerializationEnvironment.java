package eu._5gzorro.manager.dlt.corda.utils.serialization;

import net.corda.core.serialization.SerializationContext;
import net.corda.core.serialization.SerializationFactory;
import net.corda.core.serialization.internal.CheckpointSerializationContext;
import net.corda.core.serialization.internal.CheckpointSerializer;
import net.corda.core.serialization.internal.SerializationEnvironment;
import net.corda.core.serialization.internal.SerializationEnvironmentKt;
import net.corda.testing.internal.InternalSerializationTestHelpersKt;
import org.jetbrains.annotations.NotNull;

public class CustomSerializationEnvironment implements SerializationEnvironment, AutoCloseable {
  SerializationEnvironment previousSerializationEnvironment = null;

  SerializationFactory serializationFactory;
  SerializationContext p2pContext;
  SerializationContext rpcServerContext = null;
  SerializationContext rpcClientContext = null;
  SerializationContext storageContext = null;

  CheckpointSerializationContext checkpointContext = null;
  CheckpointSerializer checkpointSerializer = null;

  public CustomSerializationEnvironment(ClassLoader classLoader) {
    SerializationEnvironment env =
        InternalSerializationTestHelpersKt.createTestSerializationEnv(classLoader);
    this.serializationFactory = env.getSerializationFactory();
    this.p2pContext = env.getP2pContext();
    this.rpcClientContext = env.getRpcClientContext();
    this.rpcServerContext = env.getRpcServerContext();
    this.storageContext = env.getStorageContext();
    this.checkpointContext = env.getCheckpointContext();
    this.checkpointSerializer = env.getCheckpointSerializer();

    this.close();
    this.enable();
  }

  public void enable() {
    previousSerializationEnvironment =
        SerializationEnvironmentKt.get_driverSerializationEnv().get();
    SerializationEnvironmentKt.get_driverSerializationEnv().set(this);
  }

  public void close() {
    SerializationEnvironmentKt.get_driverSerializationEnv().set(previousSerializationEnvironment);

    InternalSerializationTestHelpersKt.getInVMExecutors().remove(this);
    SerializationEnvUtil.clearEnv();
  }

  @NotNull
  @Override
  public CheckpointSerializationContext getCheckpointContext() {
    return checkpointContext;
  }

  @NotNull
  @Override
  public CheckpointSerializer getCheckpointSerializer() {
    return checkpointSerializer;
  }

  @NotNull
  @Override
  public SerializationContext getP2pContext() {
    return p2pContext;
  }

  @NotNull
  @Override
  public SerializationContext getRpcClientContext() {
    return rpcClientContext;
  }

  @NotNull
  @Override
  public SerializationContext getRpcServerContext() {
    return rpcServerContext;
  }

  @NotNull
  @Override
  public SerializationFactory getSerializationFactory() {
    return serializationFactory;
  }

  @NotNull
  @Override
  public SerializationContext getStorageContext() {
    return storageContext;
  }
}
