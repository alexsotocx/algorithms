import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ThreePlusOneTest100 {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void problemInputs() throws IOException {
    String input  = "1 10\n" +
        "100 200\n" +
        "201 210\n" +
        "900 1000\n";
    setIn(input);

    ThreePlusOne.main(new String[]{});

    String output = "1 10 20\n" +
        "100 200 125\n" +
        "201 210 89\n" +
        "900 1000 174\n";
    assertEquals(output, outContent.toString());
  }

  private void setIn(String input) {
    System.setIn(new ByteArrayInputStream(input.getBytes()));
  }

  @After
  public void restoreStreams() {
    System.setOut(System.out);
    System.setIn(System.in);
  }
}
