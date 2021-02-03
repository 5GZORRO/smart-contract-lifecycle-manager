package eu._5gzorro.models.types;

import net.corda.core.serialization.CordaSerializable;

@CordaSerializable
public enum ReconciliationType {
  VCDR,
  BILATERAL,
  DOT;
}
