package eu._5gzorro.manager.dlt.corda.whitelist;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.Place;
import eu._5gzorro.manager.domain.ProductOfferTerm;
import eu._5gzorro.manager.domain.ServiceCandidate;
import eu._5gzorro.manager.domain.ServiceLevelAgreement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.corda.core.serialization.SerializationWhitelist;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendedSerializationWhitelist implements SerializationWhitelist {

  private static final Logger log = LoggerFactory.getLogger(ExtendedSerializationWhitelist.class);

  @NotNull
  @Override
  public List<Class<?>> getWhitelist() {
    try {
      Set<Class<?>> whitelist = new HashSet<>();
      whitelist.add(Invitation.class);
      whitelist.add(Place.class);
      whitelist.add(ProductOfferTerm.class);
      whitelist.add(ServiceCandidate.class);
      whitelist.add(ServiceLevelAgreement.class);

      whitelist.addAll(nextworksWhitelist());
      log.info("Corda Serialisation class whitelist: {}", whitelist);
      return new ArrayList<>(whitelist);
    } catch (Exception e) {
      log.error("Failed to load nextworks info models");
      throw new IllegalStateException("Failed to load nextworks info models");
    }
  }

  private Set<Class<?>> nextworksWhitelist() {
    Set<Class<?>> whitelist = new HashSet<>();
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ExportJob.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogBatchEventPayload.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.InputStream.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingAttributeValueChangeEventPayload.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryRef.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryDeleteNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.Money.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecCharacteristicValue.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.ServiceCandidateRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.PricingLogicAlgorithm.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.TaxItem.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCategoryUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.Quantity.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingDeleteEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.Category.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.File.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogDeleteEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogChangeNotification.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ExportJob.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceAttributeValueChangeEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.PhysicalResourceSpec.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.Catalog.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCandidateUpdate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecificationUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ExportJobCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogDeleteNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategory.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.TargetServiceSchema.class);
    whitelist.add(eu._5gzorro.manager.domain.ServiceCandidate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.LogicalResourceSpecUpdate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.PhysicalResourceSpecUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCategoryRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.LogicalResourceSpec.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingTerm.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.TargetResourceSchemaRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ImportJobCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.AgreementRef.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecCharRelationship.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecificationCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingStateChangeEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCreateEventPayload.class);
    whitelist.add(eu._5gzorro.manager.domain.ServiceLevelAgreement.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.URL.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ImportJobCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCharacteristicValue.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationCreateEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.LifecycleStatusEnumEnum.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCreateEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCharacteristicValueUse.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ImportJob.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogCreate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogCreateEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.TargetProductSchema.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryCreate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.SLARef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.EventSubscriptionInput.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.ResourceSpecificationRef.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryChangeEvent.class);
    whitelist.add(eu._5gzorro.manager.domain.Invitation.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateChangeEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecification.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryDeleteEventPayload.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogBatchEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingCreateEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ImportJob.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceLevelSpecificationRef.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryCreateEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceDeleteEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCatalogCreate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateCreateEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryCreateEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryDeleteEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.AttachmentRef.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCharacteristic.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogDeleteEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.MarketSegmentRef.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCharacteristicRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.Error.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationChangeNotification.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateChangeNotification.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingStateChangeEventPayload.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.BundledProductSpecification.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationDeleteEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecCharacteristic.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCatalogUpdate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryCreateNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryUpdate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingCreateEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationChangeEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.PhysicalResourceSpecCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.Error.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.ResourceCandidateRef.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryDeleteEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalog.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationDeleteEventPayload.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.PlaceRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationCreateNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.Any.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ImportJobCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogCreateEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceCreateEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecCharacteristicValue.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceStateChangeEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.Error.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationRelationship.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ChannelRef.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.BundledProductOfferingPriceRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ExportJob.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCandidateCreate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateCreateNotification.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateDeleteEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.RelatedParty.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceDescriptor.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceCreateEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogCreateNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.StatusEnum.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.BundledProductOfferingOption.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ByteArrayResource.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCandidate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateDeleteNotification.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogChangeEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.ServiceSpecificationRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCategoryCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceDescriptorAttr.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecCharRelationship.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCandidateUpdate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogCreateEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationDeleteNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ImportJob.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.EventSubscription.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ExportJobCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCategory.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogBatchNotification.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.ExportJobCreate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogBatchEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPrice.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogUpdate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.ResourceCatalog.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceCategoryChangeNotification.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceStateChangeEventPayload.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationDeleteEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceAttributeValueChangeEventPayload.class);
    whitelist.add(eu._5gzorro.manager.domain.Place.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ConstraintRef.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingRef.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.product.ProductSpecificationCreate.class);
    whitelist.add(eu._5gzorro.manager.domain.ProductOfferTerm.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceCatalogDeleteEvent.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecificationUpdate.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingDeleteEventPayload.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CategoryCreateEvent.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.CatalogCreate.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.resource.LogicalResourceSpecCreate.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.Attachment.class);
    whitelist
        .add(it.nextworks.tmf_offering_catalog.information_models.service.ServiceSpecCharacteristic.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.TimePeriod.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.BundledProductOffering.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.service.URI.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.resource.Feature.class);
    whitelist.add(it.nextworks.tmf_offering_catalog.information_models.product.AttachmentRefOrValue.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingAttributeValueChangeEvent.class);
    whitelist.add(
        it.nextworks.tmf_offering_catalog.information_models.product.ProductOfferingPriceDeleteEventPayload.class);

    return whitelist;
  }
}
