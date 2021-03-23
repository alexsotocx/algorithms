package Month30Challenge.SecondWeek;

public class StringShifts {
  final static int LEFT = 0;

  public String stringShift(String s, int[][] shifts) {
    int startIndex = 0;
    int n = s.length();
    for (int[] shift : shifts) {
      int direction = shift[0];
      int num = shift[1];
      if (direction == LEFT) {
        startIndex = (startIndex + n - (num % n)) % n;
      } else {
        startIndex = (startIndex + num) % n;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) sb.append(s.charAt((i + n - startIndex) % n));
    return sb.toString();
  }
}
