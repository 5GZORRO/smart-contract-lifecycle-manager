package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * An amount in a given unit
 */





public class Quantity {


  private Float amount = null;


  private String units = null;

  public Quantity amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Numeric value in a given unit
   *
  **/



  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Quantity units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Unit
   *
  **/



  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quantity quantity = (Quantity) o;
    return Objects.equals(this.amount, quantity.amount) &&
        Objects.equals(this.units, quantity.units);
  }


  public int hashCode() {
    return Objects.hash(amount, units);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quantity {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
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

