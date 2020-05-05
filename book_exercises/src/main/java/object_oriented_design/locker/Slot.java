package object_oriented_design.locker;

public class Slot {
  private SizeEnum size;
  private String id;

  public Slot(SizeEnum size, String id) {
    this.size = size;
    this.id = id;
  }

  public SizeEnum getSize() {
    return size;
  }

  public String getId() {
    return id;
  }
}
