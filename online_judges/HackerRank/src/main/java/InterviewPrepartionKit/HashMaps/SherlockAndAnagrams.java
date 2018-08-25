package InterviewPrepartionKit.HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
  static int sherlockAndAnagrams(String s) {
    int n = s.length();
    HashMap[] subStrings = new HashMap[n + 1];
    for(int i = 0; i <= n; i++) subStrings[i] = new HashMap<String, Integer>();
    int ans = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j <= n; j++){
        char[] sub2 = s.substring(i, j).toCharArray();
        Arrays.sort(sub2);
        String sub = new String(sub2);

        HashMap<String, Integer> temp = subStrings[j - i];
        int count = temp.getOrDefault(sub, 0);
        ans += count;
        temp.put(sub, count + 1);
      }
    }
    return ans;
  }
}
