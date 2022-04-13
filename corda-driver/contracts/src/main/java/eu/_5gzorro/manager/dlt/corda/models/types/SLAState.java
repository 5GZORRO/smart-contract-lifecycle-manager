package eu._5gzorro.manager.dlt.corda.models.types;

import net.corda.core.serialization.CordaSerializable;

@CordaSerializable
public enum SLAState {
    IN_PLACE,
    VIOLATED,
    RETIRED
}
