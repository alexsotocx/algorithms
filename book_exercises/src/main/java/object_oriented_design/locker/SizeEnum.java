package object_oriented_design.locker;

public enum SizeEnum implements Comparable<SizeEnum> {
  SMALL(0),
  MEDIUM(1),
  Large(2);

  private final int size;

  private SizeEnum(int sizeCode) {
    this.size = sizeCode;
  }

  public int getSizeCode() {
    return size;
  }

}
