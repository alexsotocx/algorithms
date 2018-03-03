import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BrokenKeyBoardTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void problemInputs() {
    String input  = "This_is_a_[Beiju]_text\n" +
        "[[]][][]Happy_Birthday_to_Tsinghua_University\n";
    setIn(input);

    BrokenKeyBoard.main(new String[]{});

    String output = "BeijuThis_is_a__text\n" +
        "Happy_Birthday_to_Tsinghua_University\n";
    assertEquals(output, outContent.toString());
  }

  @Test
  public void uvaInput() {

    String input  = "iiiii[hhhhh[ggggg]jjjjj]kkkkk]lllll]mmmmm]nnnnn]]ooooo[fffff]ppppp]qqqqq[eeeee]rrrrr[ddddd]sssss]ttttt]uuuuu[ccccc[bbbbb[aaaaa\n" +
        "[][][][][yy][ww]ff[ee]uu]]]pp]oo]Q]yy]kk]bb][rr]\n" +
        "[a][b]c[]d[e]]]f]g[]dd[][][]dd[[d]]]d";
    setIn(input);

    BrokenKeyBoard.main(new String[]{});

    String output = "aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuu\n" +
        "rreewwyyffuuppooQyykkbb\n" +
        "debacdfgddddd\n";
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
