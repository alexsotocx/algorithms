import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class BrokenKeyBoard {

  public static void main(String args[]) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringBuilder output = new StringBuilder();
    try {
      while ((line = in.readLine()) != null) {
        Deque<String> text = new LinkedList<>();
        boolean writingAtStart = false;

        char[] input = line.toCharArray();
        for (int i = 0; i < input.length; ) {
          char c = input[i];
          if (c == '[') writingAtStart = true;
          else if (c == ']') {
            writingAtStart = false;
          } else {
            if (writingAtStart) {
              StringBuilder st = new StringBuilder();
              while (i < input.length && input[i] != '[' && input[i] != ']') {
                st.append(input[i++]);
              }
              writingAtStart = false;
              text.addFirst(st.toString());
              continue;
            } else
              text.addLast(String.valueOf(c));
          }
          i++;
        }
        for (String atext : text) output.append(atext);
        output.append('\n');
      }
      System.out.print(output);
    } catch (IOException e) {
      //e.printStackTrace();
    }
  }
}

