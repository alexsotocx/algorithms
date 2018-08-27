package InterviewPrepartionKit.Sorting;

public class FraudulentActivityNotificaitons {
  float median(int[] count, int d) {
    float m = 0;
    boolean isEven = (d % 2 == 0);
    int dd = 0;
    for (int i = 0; i < count.length; i++) {
      int c = count[i];
      if (dd > d / 2) break;
      if (c == 0) continue;
      while (c-- > 0) {
        if (dd > d / 2) break;
        if ((isEven && (dd == (d - 1) / 2)) || dd == d / 2) m += i;
        dd++;
      }
    }
    return isEven ? m / 2 : m;
  }

  // Complete the activityNotifications function below.
  int activityNotifications(int[] expenditure, int d) {
    int[] count = new int[201];
    int n = expenditure.length;
    int c = 0;
    for (int i = 0; i < n; i++) {
      if (i < d) count[expenditure[i]]++;
      else {
        if (expenditure[i] >= 2 * median(count, d)) c++;
        count[expenditure[i]]++;
        count[expenditure[i - d]]--;
      }
    }
    return c;
  }
}
