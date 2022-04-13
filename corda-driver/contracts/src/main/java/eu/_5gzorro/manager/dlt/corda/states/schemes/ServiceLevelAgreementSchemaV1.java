package eu._5gzorro.manager.dlt.corda.states.schemes;

import com.sun.istack.Nullable;
import net.corda.core.schemas.MappedSchema;
import net.corda.core.schemas.PersistentState;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.UUID;

public class ServiceLevelAgreementSchemaV1 extends MappedSchema {

    public ServiceLevelAgreementSchemaV1() {
        super(ServiceLevelAgreementSchema.class, 1, Arrays.asList(ServiceLevelAgreement.class));
    }

    @Entity
    @Table(name = "service_level_agreements")
    public static class ServiceLevelAgreement extends PersistentState {

        @Column(name = "linear_id")
        @Type(type = "uuid-char")
        private final UUID linearID;

        @Column(name = "product_order_did")
        private final String productOrderDID;

        @Column(name = "service_level_agreement_did")
        private final String serviceLevelAgreementDID;

        public ServiceLevelAgreement(UUID linearID,
                                     String productOrderDID,
                                     String serviceLevelAgreementDID) {
            this.linearID = linearID;
            this.productOrderDID = productOrderDID;
            this.serviceLevelAgreementDID = serviceLevelAgreementDID;
        }

        public ServiceLevelAgreement() {
            linearID = null;
            productOrderDID = null;
            serviceLevelAgreementDID = null;
        }

        public UUID getLinearID() { return linearID; }

        public String getProductOrderDID() { return productOrderDID; }

        public String getServiceLevelAgreementDID() { return serviceLevelAgreementDID; }
    }

    @Nullable
    @Override
    public String getMigrationResource() {
        return "sla.changelog-master";
    }
}
