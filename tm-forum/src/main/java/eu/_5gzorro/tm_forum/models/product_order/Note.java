package eu._5gzorro.tm_forum.models.product_order;

import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/** Extra information about a given entity */
public class Note {
  private String text;
  private String date;
  private String author;

  public Note text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Texte of the note
   *
   * @return text
   */
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Note date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the note
   *
   * @return date
   */
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Note author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Author of the note
   *
   * @return author
   */
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  /** Return true if this Note object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Note note = (Note) o;
    return Objects.equals(this.text, note.text)
        && Objects.equals(this.date, note.date)
        && Objects.equals(this.author, note.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, date, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Note {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
