package modeling.library;

public class Book {
  private int isdn;
  private String name;
  private Author author;

  public Book(int isdn, String name, Author author) {
    this.isdn = isdn;
    this.name = name;
    this.author = author;
  }

  public int getIsdn() {
    return isdn;
  }

  public void setIsdn(int isdn) {
    this.isdn = isdn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
