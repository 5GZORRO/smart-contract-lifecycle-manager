package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.PlaceRef;
import eu._5gzorro.tm_forum.models.Quantity;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Is based on both the basic cost to develop and produce products and the enterprises policy on revenue targets. This price may be further revised through discounting (productOfferPriceAlteration). The price, applied for a productOffering may also be influenced by the productOfferingTerm, the customer selected, eg: a productOffering can be offered with multiple terms, like commitment periods for the contract. The price may be influenced by this productOfferingTerm. A productOffering may be cheaper with a 24 month commitment than with a 12 month commitment.
 */






public class ProductOfferingPrice {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
 
 
 
  private List<BundledProductOfferingPriceRelationship> bundledPopRelationship = null;

 
 
 
 
  private List<ConstraintRef> constraint = null;

 
  private String description = null;

 
  private String href = null;

 
  private String id = null;

 
 
  private Boolean isBundle = null;

 
 
  private String lastUpdate = null;

 
 
  private String lifecycleStatus = null;

 
  private String name = null;

 
  private Float percentage = null;

 
 
 
 
  private List<PlaceRef> place = null;

 
 
 
 
  private List<ProductOfferingPriceRelationship> popRelationship = null;

 
 
  private Money price = null;

 
 
  private String priceType = null;

 
 
 
 
  private List<PricingLogicAlgorithm> pricingLogicAlgorithm = null;

 
 
 
 
  private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse = null;

 
 
 
 
  private List<ProductOfferingTerm> productOfferingTerm = null;

 
 
  private Integer recurringChargePeriodLength = null;

 
 
  private String recurringChargePeriodType = null;

 
 
 
 
  private List<TaxItem> tax = null;

 
 
 
  private Quantity unitOfMeasure = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ProductOfferingPrice baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   *
  **/
 


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ProductOfferingPrice schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   *
  **/
 


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ProductOfferingPrice type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProductOfferingPrice bundledPopRelationship(List<BundledProductOfferingPriceRelationship> bundledPopRelationship) {
    this.bundledPopRelationship = bundledPopRelationship;
    return this;
  }

  public ProductOfferingPrice addBundledPopRelationshipItem(BundledProductOfferingPriceRelationship bundledPopRelationshipItem) {
    if (this.bundledPopRelationship == null) {
      this.bundledPopRelationship = new ArrayList<BundledProductOfferingPriceRelationship>();
    }
    this.bundledPopRelationship.add(bundledPopRelationshipItem);
    return this;
  }

  /**
   * this object represents a bundle relationship from a bundle product offering price (parent) to a simple product offering price (child). A simple product offering price may participate in more than one bundle relationship.
   *
  **/
 

 

  public List<BundledProductOfferingPriceRelationship> getBundledPopRelationship() {
    return bundledPopRelationship;
  }

  public void setBundledPopRelationship(List<BundledProductOfferingPriceRelationship> bundledPopRelationship) {
    this.bundledPopRelationship = bundledPopRelationship;
  }

  public ProductOfferingPrice constraint(List<ConstraintRef> constraint) {
    this.constraint = constraint;
    return this;
  }

  public ProductOfferingPrice addConstraintItem(ConstraintRef constraintItem) {
    if (this.constraint == null) {
      this.constraint = new ArrayList<ConstraintRef>();
    }
    this.constraint.add(constraintItem);
    return this;
  }

  /**
   * The Constraint resource represents a policy/rule applied to ProductOfferingPrice.
   *
  **/
 

 

  public List<ConstraintRef> getConstraint() {
    return constraint;
  }

  public void setConstraint(List<ConstraintRef> constraint) {
    this.constraint = constraint;
  }

  public ProductOfferingPrice description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this catalog
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductOfferingPrice href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the entity
   *
  **/
 


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingPrice id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique id of this resource
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingPrice isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * A flag indicating if this ProductOfferingPrice is composite (bundle) or not
   *
  **/
 


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductOfferingPrice lastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   *
  **/
 


  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ProductOfferingPrice lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   *
  **/
 


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ProductOfferingPrice name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the entity
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductOfferingPrice percentage(Float percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Percentage to apply for ProductOfferPriceAlteration (Discount)
   *
  **/
 


  public Float getPercentage() {
    return percentage;
  }

  public void setPercentage(Float percentage) {
    this.percentage = percentage;
  }

  public ProductOfferingPrice place(List<PlaceRef> place) {
    this.place = place;
    return this;
  }

  public ProductOfferingPrice addPlaceItem(PlaceRef placeItem) {
    if (this.place == null) {
      this.place = new ArrayList<PlaceRef>();
    }
    this.place.add(placeItem);
    return this;
  }

  /**
   * Place defines the places where the products are sold or delivered.
   *
  **/
 

 

  public List<PlaceRef> getPlace() {
    return place;
  }

  public void setPlace(List<PlaceRef> place) {
    this.place = place;
  }

  public ProductOfferingPrice popRelationship(List<ProductOfferingPriceRelationship> popRelationship) {
    this.popRelationship = popRelationship;
    return this;
  }

  public ProductOfferingPrice addPopRelationshipItem(ProductOfferingPriceRelationship popRelationshipItem) {
    if (this.popRelationship == null) {
      this.popRelationship = new ArrayList<ProductOfferingPriceRelationship>();
    }
    this.popRelationship.add(popRelationshipItem);
    return this;
  }

  /**
   * Product Offering Prices related to this Product Offering Price, for example a price alteration such as allowance or discount
   *
  **/
 

 

  public List<ProductOfferingPriceRelationship> getPopRelationship() {
    return popRelationship;
  }

  public void setPopRelationship(List<ProductOfferingPriceRelationship> popRelationship) {
    this.popRelationship = popRelationship;
  }

  public ProductOfferingPrice price(Money price) {
    this.price = price;
    return this;
  }

  /**
   * The amount of money that characterizes the price.
   *
  **/
 

 

  public Money getPrice() {
    return price;
  }

  public void setPrice(Money price) {
    this.price = price;
  }

  public ProductOfferingPrice priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * A category that describes the price, such as recurring, discount, allowance, penalty, and so forth.
   *
  **/
 


  public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public ProductOfferingPrice pricingLogicAlgorithm(List<PricingLogicAlgorithm> pricingLogicAlgorithm) {
    this.pricingLogicAlgorithm = pricingLogicAlgorithm;
    return this;
  }

  public ProductOfferingPrice addPricingLogicAlgorithmItem(PricingLogicAlgorithm pricingLogicAlgorithmItem) {
    if (this.pricingLogicAlgorithm == null) {
      this.pricingLogicAlgorithm = new ArrayList<PricingLogicAlgorithm>();
    }
    this.pricingLogicAlgorithm.add(pricingLogicAlgorithmItem);
    return this;
  }

  /**
   * The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled behavior in SID). Some of the parameters of the interface definition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth).
   *
  **/
 

 

  public List<PricingLogicAlgorithm> getPricingLogicAlgorithm() {
    return pricingLogicAlgorithm;
  }

  public void setPricingLogicAlgorithm(List<PricingLogicAlgorithm> pricingLogicAlgorithm) {
    this.pricingLogicAlgorithm = pricingLogicAlgorithm;
  }

  public ProductOfferingPrice prodSpecCharValueUse(List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
    this.prodSpecCharValueUse = prodSpecCharValueUse;
    return this;
  }

  public ProductOfferingPrice addProdSpecCharValueUseItem(ProductSpecificationCharacteristicValueUse prodSpecCharValueUseItem) {
    if (this.prodSpecCharValueUse == null) {
      this.prodSpecCharValueUse = new ArrayList<ProductSpecificationCharacteristicValueUse>();
    }
    this.prodSpecCharValueUse.add(prodSpecCharValueUseItem);
    return this;
  }

  /**
   * A use of the ProductSpecificationCharacteristicValue by a ProductOfferingPrice to which additional properties (attributes) apply or override the properties of similar properties contained in ProductSpecificationCharacteristicValue. It should be noted that characteristics which their value(s) addressed by this object must exist in corresponding product specification. The available characteristic values for a ProductSpecificationCharacteristic in a Product specification can be modified at the ProductOffering and ProcuctOfferingPrice level. The list of values in ProductSpecificationCharacteristicValueUse is a strict subset of the list of values as defined in the corresponding product specification characteristics.
   *
  **/
 

 

  public List<ProductSpecificationCharacteristicValueUse> getProdSpecCharValueUse() {
    return prodSpecCharValueUse;
  }

  public void setProdSpecCharValueUse(List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
    this.prodSpecCharValueUse = prodSpecCharValueUse;
  }

  public ProductOfferingPrice productOfferingTerm(List<ProductOfferingTerm> productOfferingTerm) {
    this.productOfferingTerm = productOfferingTerm;
    return this;
  }

  public ProductOfferingPrice addProductOfferingTermItem(ProductOfferingTerm productOfferingTermItem) {
    if (this.productOfferingTerm == null) {
      this.productOfferingTerm = new ArrayList<ProductOfferingTerm>();
    }
    this.productOfferingTerm.add(productOfferingTermItem);
    return this;
  }

  /**
   * A list of conditions under which a ProductOfferingPrice is made available to Customers. For instance, a Product Offering Price can be offered with multiple commitment periods.
   *
  **/
 

 

  public List<ProductOfferingTerm> getProductOfferingTerm() {
    return productOfferingTerm;
  }

  public void setProductOfferingTerm(List<ProductOfferingTerm> productOfferingTerm) {
    this.productOfferingTerm = productOfferingTerm;
  }

  public ProductOfferingPrice recurringChargePeriodLength(Integer recurringChargePeriodLength) {
    this.recurringChargePeriodLength = recurringChargePeriodLength;
    return this;
  }

  /**
   * the period of the recurring charge:  1, 2, ... .It sets to zero if it is not applicable
   *
  **/
 


  public Integer getRecurringChargePeriodLength() {
    return recurringChargePeriodLength;
  }

  public void setRecurringChargePeriodLength(Integer recurringChargePeriodLength) {
    this.recurringChargePeriodLength = recurringChargePeriodLength;
  }

  public ProductOfferingPrice recurringChargePeriodType(String recurringChargePeriodType) {
    this.recurringChargePeriodType = recurringChargePeriodType;
    return this;
  }

  /**
   * The period to repeat the application of the price Could be month, week...
   *
  **/
 


  public String getRecurringChargePeriodType() {
    return recurringChargePeriodType;
  }

  public void setRecurringChargePeriodType(String recurringChargePeriodType) {
    this.recurringChargePeriodType = recurringChargePeriodType;
  }

  public ProductOfferingPrice tax(List<TaxItem> tax) {
    this.tax = tax;
    return this;
  }

  public ProductOfferingPrice addTaxItem(TaxItem taxItem) {
    if (this.tax == null) {
      this.tax = new ArrayList<TaxItem>();
    }
    this.tax.add(taxItem);
    return this;
  }

  /**
   * An amount of money levied on the price of a Product by a legislative body.
   *
  **/
 

 

  public List<TaxItem> getTax() {
    return tax;
  }

  public void setTax(List<TaxItem> tax) {
    this.tax = tax;
  }

  public ProductOfferingPrice unitOfMeasure(Quantity unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * A number and unit representing how many (for instance 1 dozen) of an ProductOffering is available at the offered price. Its meaning depends on the priceType. It could be a price, a rate, or a discount.
   *
  **/
 

 

  public Quantity getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(Quantity unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public ProductOfferingPrice uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   *
  **/
 


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ProductOfferingPrice validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the entity is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ProductOfferingPrice version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Entity version
   *
  **/
 


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingPrice productOfferingPrice = (ProductOfferingPrice) o;
    return Objects.equals(this.baseType, productOfferingPrice.baseType) &&
        Objects.equals(this.schemaLocation, productOfferingPrice.schemaLocation) &&
        Objects.equals(this.type, productOfferingPrice.type) &&
        Objects.equals(this.bundledPopRelationship, productOfferingPrice.bundledPopRelationship) &&
        Objects.equals(this.constraint, productOfferingPrice.constraint) &&
        Objects.equals(this.description, productOfferingPrice.description) &&
        Objects.equals(this.href, productOfferingPrice.href) &&
        Objects.equals(this.id, productOfferingPrice.id) &&
        Objects.equals(this.isBundle, productOfferingPrice.isBundle) &&
        Objects.equals(this.lastUpdate, productOfferingPrice.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, productOfferingPrice.lifecycleStatus) &&
        Objects.equals(this.name, productOfferingPrice.name) &&
        Objects.equals(this.percentage, productOfferingPrice.percentage) &&
        Objects.equals(this.place, productOfferingPrice.place) &&
        Objects.equals(this.popRelationship, productOfferingPrice.popRelationship) &&
        Objects.equals(this.price, productOfferingPrice.price) &&
        Objects.equals(this.priceType, productOfferingPrice.priceType) &&
        Objects.equals(this.pricingLogicAlgorithm, productOfferingPrice.pricingLogicAlgorithm) &&
        Objects.equals(this.prodSpecCharValueUse, productOfferingPrice.prodSpecCharValueUse) &&
        Objects.equals(this.productOfferingTerm, productOfferingPrice.productOfferingTerm) &&
        Objects.equals(this.recurringChargePeriodLength, productOfferingPrice.recurringChargePeriodLength) &&
        Objects.equals(this.recurringChargePeriodType, productOfferingPrice.recurringChargePeriodType) &&
        Objects.equals(this.tax, productOfferingPrice.tax) &&
        Objects.equals(this.unitOfMeasure, productOfferingPrice.unitOfMeasure) &&
        Objects.equals(this.uuid, productOfferingPrice.uuid) &&
        Objects.equals(this.validFor, productOfferingPrice.validFor) &&
        Objects.equals(this.version, productOfferingPrice.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, bundledPopRelationship, constraint, description, href, id, isBundle, lastUpdate, lifecycleStatus, name, percentage, place, popRelationship, price, priceType, pricingLogicAlgorithm, prodSpecCharValueUse, productOfferingTerm, recurringChargePeriodLength, recurringChargePeriodType, tax, unitOfMeasure, uuid, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingPrice {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    bundledPopRelationship: ").append(toIndentedString(bundledPopRelationship)).append("\n");
    sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    popRelationship: ").append(toIndentedString(popRelationship)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    pricingLogicAlgorithm: ").append(toIndentedString(pricingLogicAlgorithm)).append("\n");
    sb.append("    prodSpecCharValueUse: ").append(toIndentedString(prodSpecCharValueUse)).append("\n");
    sb.append("    productOfferingTerm: ").append(toIndentedString(productOfferingTerm)).append("\n");
    sb.append("    recurringChargePeriodLength: ").append(toIndentedString(recurringChargePeriodLength)).append("\n");
    sb.append("    recurringChargePeriodType: ").append(toIndentedString(recurringChargePeriodType)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

