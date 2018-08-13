package chapter8;

import org.junit.Test;

import java.util.ArrayList;

public class E8_13Test {

  @Test
  public void maxHeight() {
    ArrayList<Box> boxes = new ArrayList<>();
    boxes.add(new Box(1, 7, 4));
    boxes.add(new Box(2, 6, 9));
    boxes.add(new Box(4, 9, 6));
    boxes.add(new Box(10, 12, 8));
    boxes.add(new Box(6, 2, 5));
    boxes.add(new Box(3, 8, 5));
    boxes.add(new Box(5, 7, 7));
    boxes.add(new Box(2, 10, 16));
    boxes.add(new Box(12, 15, 9));

    System.out.println(new E8_13(boxes).maxHeight());
  }
}