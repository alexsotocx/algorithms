package InterviewPrepartionKit.Search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class cSf {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
      TreeSet<Long> data = new TreeSet<>();
      long[] prefix = new long[a.length + 1];
      long ret = 0, current = 0;

      for(int i = 0; i < a.length; i++) {
        prefix[i] = current = (current + a[i]) % m;
        data.add(current);
        Long high = data.higher(current);
        if(high == null) high = 0L;
        ret = Math.max(ret, Math.max(a[i] % m, (current - high +  m)%m));
      }
      return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
