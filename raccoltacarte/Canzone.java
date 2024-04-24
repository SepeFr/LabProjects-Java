package raccoltacarte;

public class Canzone implements Comparable<Canzone> {
  private String name;
  private String author;

  private static String DEFAULT_AUTHOR = "unknown";
  private static String DEFAULT_NAME = "undefined";

  Canzone(String name, String author) {
    this.name = name;
    this.author = author;
  }

  Canzone() {
    this(DEFAULT_NAME, DEFAULT_AUTHOR);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null | this.getClass() != obj.getClass()) return false;
    Canzone context = (Canzone) obj;
    return (this.getName().equals(context.getName())
        & this.getAuthor().equals(context.getAuthor()));
  }

  @Override
  public int compareTo(Canzone o) {
    int result = this.getName().compareTo(o.getName());
    if (result == 0) {
      return this.getAuthor().compareTo(o.getAuthor());
    }
    return result;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.name != null ? this.getName().hashCode() : 0);
    result = 31 * result + (this.author != null ? this.getAuthor().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return this.getName() + " - " + this.getAuthor();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }
}
