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
    whitelist.add(eu._5gzorro.tm_forum.models.product.ExportJob.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.CatalogBatchEventPayload.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.InputStream.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingAttributeValueChangeEventPayload.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCategoryRef.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCategoryDeleteNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.Money.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecCharacteristicValue.class);
    whitelist.add(eu._5gzorro.tm_forum.models.ServiceCandidateRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.PricingLogicAlgorithm.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.TaxItem.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCategoryUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.Quantity.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductOfferingDeleteEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.Category.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.File.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.CatalogDeleteEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCatalogChangeNotification.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ExportJob.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceAttributeValueChangeEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.PhysicalResourceSpec.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.Catalog.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceCandidateUpdate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceSpecificationUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ExportJobCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCatalogDeleteNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCategory.class);
    whitelist.add(eu._5gzorro.tm_forum.models.TargetServiceSchema.class);
    whitelist.add(eu._5gzorro.manager.domain.ServiceCandidate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.LogicalResourceSpecUpdate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.PhysicalResourceSpecUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCategoryRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.LogicalResourceSpec.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingTerm.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.TargetResourceSchemaRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ImportJobCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.AgreementRef.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.resource.ResourceSpecCharRelationship.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceSpecificationCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingStateChangeEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCreateEventPayload.class);
    whitelist.add(eu._5gzorro.manager.domain.ServiceLevelAgreement.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.URL.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ImportJobCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCharacteristicValue.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationCreateEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.LifecycleStatusEnumEnum.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCreateEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCharacteristicValueUse.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ImportJob.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCatalogCreate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCatalogCreateEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.TargetProductSchema.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCategoryCreate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductOfferingPriceUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.SLARef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.EventSubscriptionInput.class);
    whitelist.add(eu._5gzorro.tm_forum.models.ResourceSpecificationRef.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCategoryChangeEvent.class);
    whitelist.add(eu._5gzorro.manager.domain.Invitation.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCandidateChangeEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductOfferingPriceCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceSpecification.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.CategoryDeleteEventPayload.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CatalogBatchEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductOfferingCreateEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ImportJob.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceLevelSpecificationRef.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.CategoryCreateEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceDeleteEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductSpecificationUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCatalogCreate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCandidateCreateEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCategoryCreateEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CategoryDeleteEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.AttachmentRef.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceSpecRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCharacteristic.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CatalogDeleteEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCatalogUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.MarketSegmentRef.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationCharacteristicRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.Error.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationChangeNotification.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCandidateChangeNotification.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingStateChangeEventPayload.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.BundledProductSpecification.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationDeleteEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceSpecCharacteristic.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCatalogUpdate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCategoryCreateNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCategoryUpdate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingCreateEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationChangeEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.PhysicalResourceSpecCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductSpecification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceSpecRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.Error.class);
    whitelist.add(eu._5gzorro.tm_forum.models.ResourceCandidateRef.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCategoryDeleteEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCatalog.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationDeleteEventPayload.class);
    whitelist.add(eu._5gzorro.tm_forum.models.PlaceRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCandidate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationCreateNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.Any.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOffering.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ImportJobCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CatalogCreateEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceCreateEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.resource.ResourceSpecCharacteristicValue.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCandidateCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceStateChangeEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.Error.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductSpecificationRelationship.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceSpecificationCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ChannelRef.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.BundledProductOfferingPriceRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CategoryUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ExportJob.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.ResourceCandidateCreate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCandidateCreateNotification.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCandidateDeleteEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.RelatedParty.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceDescriptor.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceCreateEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCatalogCreateNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.StatusEnum.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.BundledProductOfferingOption.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ByteArrayResource.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCandidate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCandidateDeleteNotification.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCatalogChangeEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.ServiceSpecificationRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCategoryCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceDescriptorAttr.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceSpecCharRelationship.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceSpecification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ServiceCandidateUpdate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.CatalogCreateEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationDeleteNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ImportJob.class);
    whitelist.add(eu._5gzorro.tm_forum.models.EventSubscription.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ExportJobCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCategory.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCatalogBatchNotification.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductSpecificationRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.ExportJobCreate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCatalogBatchEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CategoryCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingPrice.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CatalogUpdate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingPriceRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CategoryRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.ResourceCatalog.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceCategoryChangeNotification.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceStateChangeEventPayload.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.service.ServiceSpecificationDeleteEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceAttributeValueChangeEventPayload.class);
    whitelist.add(eu._5gzorro.manager.domain.Place.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ConstraintRef.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.ProductOfferingRef.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.product.ProductSpecificationCreate.class);
    whitelist.add(eu._5gzorro.manager.domain.ProductOfferTerm.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceCatalogDeleteEvent.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceSpecificationUpdate.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingDeleteEventPayload.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CategoryCreateEvent.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.CatalogCreate.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.resource.LogicalResourceSpecCreate.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.Attachment.class);
    whitelist
        .add(eu._5gzorro.tm_forum.models.service.ServiceSpecCharacteristic.class);
    whitelist.add(eu._5gzorro.tm_forum.models.TimePeriod.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.BundledProductOffering.class);
    whitelist.add(eu._5gzorro.tm_forum.models.service.URI.class);
    whitelist.add(eu._5gzorro.tm_forum.models.resource.Feature.class);
    whitelist.add(eu._5gzorro.tm_forum.models.product.AttachmentRefOrValue.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingAttributeValueChangeEvent.class);
    whitelist.add(
        eu._5gzorro.tm_forum.models.product.ProductOfferingPriceDeleteEventPayload.class);

    return whitelist;
  }
}
