package eu._5gzorro.manager.dlt.corda.models.types;

import net.corda.core.serialization.CordaSerializable;

@CordaSerializable
public enum LTState {
    IN_PLACE,
    VIOLATED,
    RETIRED
}
