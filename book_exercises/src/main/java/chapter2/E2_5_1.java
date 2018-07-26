package chapter2;

class E2_5Node {
  int value;
  E2_5Node next;

  public E2_5Node() {
  }

  public E2_5Node(int value) {
    this.value = value;
  }
}

public class E2_5_1 {
  public E2_5Node sumList(E2_5Node h1, E2_5Node h2) {
    E2_5Node sum = null, headSum = null, ZeroNode = new E2_5Node(0);
    int carrier = 0;
    while (h1 != null || h2 != null) {
      if (h1 == null) h1 = ZeroNode;
      else if (h2 == null) h2 = ZeroNode;
      SumResult sumResult = Sum(h1, h2, carrier);
      carrier = sumResult.carrier;
      if (sum == null) sum = headSum = sumResult.resultOp;
      else sum = sum.next = sumResult.resultOp;
      h1 = h1.next;
      h2 = h2.next;
    }

    if (carrier != 0) sum.next = new E2_5Node(carrier);
    return headSum;
  }

  private SumResult Sum(E2_5Node s1, E2_5Node s2, int carrier) {
    int sum = s1.value + s2.value + carrier;
    carrier = sum / 10;
    return new SumResult(carrier, new E2_5Node(sum % 10));
  }

  private class SumResult {
    int carrier;
    E2_5Node resultOp;

    public SumResult(int carrier, E2_5Node resultOp) {
      this.carrier = carrier;
      this.resultOp = resultOp;
    }
  }
}
