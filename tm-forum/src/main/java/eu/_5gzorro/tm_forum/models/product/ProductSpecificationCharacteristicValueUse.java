package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.LifecycleStatusEnumEnum;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to which additional properties (attributes) apply or override the properties of similar properties contained in ProductSpecificationCharacteristicValue. It should be noted that characteristics which their value(s) addressed by this object must exist in corresponding product specification. The available characteristic values for a ProductSpecificationCharacteristic in a Product specification can be modified at the ProductOffering level. For example, a characteristic &#39;Color&#39; might have values White, Blue, Green, and Red. But, the list of values can be restricted to e.g. White and Blue in an associated product offering. It should be noted that the list of values in &#39;ProductSpecificationCharacteristicValueUse&#39; is a strict subset of the list of values as defined in the corresponding product specification characteristics.
 */






public class ProductSpecificationCharacteristicValueUse {



  private String baseType = null;



  private String schemaLocation = null;


  private String type = null;


  private String description = null;


  private String href = null;



  private String lastUpdate = null;



  private String lifecycleStatus = null;



  private LifecycleStatusEnumEnum lifecycleStatusEnum = null;



  private Integer maxCardinality = null;



  private Integer minCardinality = null;


  private String name = null;





  private List<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue = null;




  private ProductSpecificationRef productSpecification = null;





  private String uuid = null;




  private TimePeriod validFor = null;



  private String valueType = null;


  private String version = null;

  public ProductSpecificationCharacteristicValueUse baseType(String baseType) {
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

  public ProductSpecificationCharacteristicValueUse schemaLocation(String schemaLocation) {
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

  public ProductSpecificationCharacteristicValueUse type(String type) {
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

  public ProductSpecificationCharacteristicValueUse description(String description) {
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

  public ProductSpecificationCharacteristicValueUse href(String href) {
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

  public ProductSpecificationCharacteristicValueUse lastUpdate(String lastUpdate) {
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

  public ProductSpecificationCharacteristicValueUse lifecycleStatus(String lifecycleStatus) {
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

  public ProductSpecificationCharacteristicValueUse lifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
    return this;
  }

  /**
   * Get lifecycleStatusEnum
   *
  **/



  public LifecycleStatusEnumEnum getLifecycleStatusEnum() {
    return lifecycleStatusEnum;
  }

  public void setLifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
  }

  public ProductSpecificationCharacteristicValueUse maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

  /**
   * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
   *
  **/



  public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public ProductSpecificationCharacteristicValueUse minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

  /**
   * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
   *
  **/



  public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public ProductSpecificationCharacteristicValueUse name(String name) {
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

  public ProductSpecificationCharacteristicValueUse productSpecCharacteristicValue(List<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
    this.productSpecCharacteristicValue = productSpecCharacteristicValue;
    return this;
  }

  public ProductSpecificationCharacteristicValueUse addProductSpecCharacteristicValueItem(ProductSpecificationCharacteristicValue productSpecCharacteristicValueItem) {
    if (this.productSpecCharacteristicValue == null) {
      this.productSpecCharacteristicValue = new ArrayList<ProductSpecificationCharacteristicValue>();
    }
    this.productSpecCharacteristicValue.add(productSpecCharacteristicValueItem);
    return this;
  }

  /**
   * A number or text that can be assigned to a ProductSpecificationCharacteristic.
   *
  **/




  public List<ProductSpecificationCharacteristicValue> getProductSpecCharacteristicValue() {
    return productSpecCharacteristicValue;
  }

  public void setProductSpecCharacteristicValue(List<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
    this.productSpecCharacteristicValue = productSpecCharacteristicValue;
  }

  public ProductSpecificationCharacteristicValueUse productSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * A ProductSpecification is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.
   *
  **/




  public ProductSpecificationRef getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
  }

  public ProductSpecificationCharacteristicValueUse uuid(String uuid) {
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

  public ProductSpecificationCharacteristicValueUse validFor(TimePeriod validFor) {
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

  public ProductSpecificationCharacteristicValueUse valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text and so forth
   *
  **/



  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public ProductSpecificationCharacteristicValueUse version(String version) {
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
    ProductSpecificationCharacteristicValueUse productSpecificationCharacteristicValueUse = (ProductSpecificationCharacteristicValueUse) o;
    return Objects.equals(this.baseType, productSpecificationCharacteristicValueUse.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationCharacteristicValueUse.schemaLocation) &&
        Objects.equals(this.type, productSpecificationCharacteristicValueUse.type) &&
        Objects.equals(this.description, productSpecificationCharacteristicValueUse.description) &&
        Objects.equals(this.href, productSpecificationCharacteristicValueUse.href) &&
        Objects.equals(this.lastUpdate, productSpecificationCharacteristicValueUse.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, productSpecificationCharacteristicValueUse.lifecycleStatus) &&
        Objects.equals(this.lifecycleStatusEnum, productSpecificationCharacteristicValueUse.lifecycleStatusEnum) &&
        Objects.equals(this.maxCardinality, productSpecificationCharacteristicValueUse.maxCardinality) &&
        Objects.equals(this.minCardinality, productSpecificationCharacteristicValueUse.minCardinality) &&
        Objects.equals(this.name, productSpecificationCharacteristicValueUse.name) &&
        Objects.equals(this.productSpecCharacteristicValue, productSpecificationCharacteristicValueUse.productSpecCharacteristicValue) &&
        Objects.equals(this.productSpecification, productSpecificationCharacteristicValueUse.productSpecification) &&
        Objects.equals(this.uuid, productSpecificationCharacteristicValueUse.uuid) &&
        Objects.equals(this.validFor, productSpecificationCharacteristicValueUse.validFor) &&
        Objects.equals(this.valueType, productSpecificationCharacteristicValueUse.valueType) &&
        Objects.equals(this.version, productSpecificationCharacteristicValueUse.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, lastUpdate, lifecycleStatus, lifecycleStatusEnum, maxCardinality, minCardinality, name, productSpecCharacteristicValue, productSpecification, uuid, validFor, valueType, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationCharacteristicValueUse {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lifecycleStatusEnum: ").append(toIndentedString(lifecycleStatusEnum)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productSpecCharacteristicValue: ").append(toIndentedString(productSpecCharacteristicValue)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
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

