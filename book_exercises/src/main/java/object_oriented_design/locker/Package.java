package object_oriented_design.locker;

public class Package {
  private String description;
  private SizeEnum size;

  public Package(String description, SizeEnum size) {
    this.description = description;
    this.size = size;
  }

  public String getDescription() {
    return description;
  }

  public SizeEnum getSize() {
    return size;
  }
}
