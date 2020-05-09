package chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleStepTest {

    @Test
    void calculate() {
      TripleStep step = new TripleStep();
      assertEquals(1, step.calculate(1));
      assertEquals(2, step.calculate(2));
      assertEquals(4, step.calculate(3));
      assertEquals(7, step.calculate(4));
    }
}
