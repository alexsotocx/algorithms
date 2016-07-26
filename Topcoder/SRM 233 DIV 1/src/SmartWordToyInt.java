import java.util.ArrayDeque;
import java.util.Queue;

public class SmartWordToyInt {
  private int[] states(char[] state) {
    int[] states = new int[8];
    //First
    for (int i = 0, j = 0; i < 4; i++) {
      char aux = state[i];
      state[i] = (char) (((state[i] - 'a' + 1) % 26) + 'a');
      states[j++] = encode(state);
      state[i] = aux;
      state[i] = (char) (((state[i] + 25 - 'a') % 26) + 'a');
      states[j++] = encode(state);
      state[i] = aux;
    }
    return states;
  }


  public int minPresses(String start, String finish, String[] forbid) {
    int encodedStart = encode(start.toCharArray());
    int encondedFinish = encode(finish.toCharArray());
    int[] dist = new int[1 + encode(new char[]{'z', 'z', 'z', 'z'})];
    boolean[] visited = new boolean[1 + encode(new char[]{'z', 'z', 'z', 'z'})];
    for (String forb : forbid) {
      String[] s = forb.split(" ");
      for (char i : s[0].toCharArray())
        for (char j : s[1].toCharArray())
          for (char k : s[2].toCharArray())
            for (char l : s[3].toCharArray())
              visited[encode(new char[]{i, j, k, l})] = true;
    }
    visited[encodedStart] = true;
    dist[encodedStart] = 0;
    Queue<Integer> queue = new ArrayDeque<Integer>();
    queue.offer(encodedStart);
    while (!queue.isEmpty()) {
      int state = queue.poll();
      if (state == encondedFinish) {
        return dist[encondedFinish];
      }
      char[] charState = decode(state);
      for (int s : states(charState)) {
        if (!visited[s]) {
          dist[s] = dist[state] + 1;
          visited[s] = true;
          queue.add(s);
        }
      }

    }
    return -1;
  }

  private char[] decode(int encoded) {
    char[] decoded = new char[4];
    int full_1 = (1 << 5) - 1;
    for (int i = 3; i >= 0; i--) {
      int temp = (encoded & (full_1 << (i * 5)));
      temp = (temp >> i * 5);
      decoded[i] = (char) (temp + 'a');
    }
    return decoded;
  }

  private int encode(char[] enconded) {
    int decoded = 0;

    for (int i = enconded.length - 1, j = 0; i >= 0; i--, j += 5) {
      int y = enconded[i] - 'a';
      decoded |= (y << j);
    }
    return decoded;
  }


}
