package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * The event data structure
 */







public class CatalogDeleteEventPayload   {
 
  private Catalog catalog = null;

  public CatalogDeleteEventPayload catalog(Catalog catalog) {
    this.catalog = catalog;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public Catalog getCatalog() {
    return catalog;
  }

  public void setCatalog(Catalog catalog) {
    this.catalog = catalog;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogDeleteEventPayload catalogDeleteEventPayload = (CatalogDeleteEventPayload) o;
    return Objects.equals(this.catalog, catalogDeleteEventPayload.catalog);
  }

 
  public int hashCode() {
    return Objects.hash(catalog);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogDeleteEventPayload {\n");
    
    sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
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

