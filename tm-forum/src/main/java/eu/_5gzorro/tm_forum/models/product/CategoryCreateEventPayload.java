package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * The event data structure
 */







public class CategoryCreateEventPayload   {
 
  private Category category = null;

  public CategoryCreateEventPayload category(Category category) {
    this.category = category;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryCreateEventPayload categoryCreateEventPayload = (CategoryCreateEventPayload) o;
    return Objects.equals(this.category, categoryCreateEventPayload.category);
  }

 
  public int hashCode() {
    return Objects.hash(category);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryCreateEventPayload {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

