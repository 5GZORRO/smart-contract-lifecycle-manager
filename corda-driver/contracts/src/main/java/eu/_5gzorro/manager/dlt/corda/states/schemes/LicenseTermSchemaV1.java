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

public class LicenseTermSchemaV1 extends MappedSchema {

    public LicenseTermSchemaV1() {
        super(LicenseTermSchema.class, 1, Arrays.asList(LicenseTerm.class));
    }

    @Entity
    @Table(name = "license_terms")
    public static class LicenseTerm extends PersistentState {

        @Column(name = "linear_id")
        @Type(type = "uuid-char")
        private final UUID linearID;

        @Column(name = "product_order_did")
        private final String productOrderDID;

        @Column(name = "product_offering_did")
        private final String productOfferingDID;

        @Column(name = "license_term_did")
        private final String licenseTermDID;

        public LicenseTerm(UUID linearID,
                           String productOrderDID,
                           String productOfferingDID,
                           String licenseTermDID) {
            this.linearID           = linearID;
            this.productOrderDID    = productOrderDID;
            this.productOfferingDID = productOfferingDID;
            this.licenseTermDID     = licenseTermDID;
        }

        public LicenseTerm() {
            this.linearID           = null;
            this.productOrderDID    = null;
            this.productOfferingDID = null;
            this.licenseTermDID     = null;
        }

        public UUID getLinearID() { return linearID; }

        public String getProductOrderDID() { return productOrderDID; }

        public String getProductOfferingDID() { return productOfferingDID; }

        public String getLicenseTermDID() { return licenseTermDID; }
    }

    @Nullable
    @Override
    public String getMigrationResource() {
        return "license-term.changelog-master";
    }
}
