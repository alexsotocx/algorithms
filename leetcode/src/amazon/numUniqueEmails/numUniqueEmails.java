package amazon.numUniqueEmails;

import java.util.HashSet;

class Solution {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> unique = new HashSet<>();
    for(String email: emails) {
      StringBuilder sb = new StringBuilder();
      boolean plusFound = false;
      for(int i = 0 ; i< email.length(); i++) {
        int c = email.charAt(i);
        if (plusFound && c != '@') continue;;
        if (c == '@') {
          sb.append(email.substring(i));
          break;
        }
        if(c == '.') continue;
        if(c == '+') {
          plusFound = true;
        } else {
          sb.append(c);
        }

      }
      unique.add(sb.toString());

    }
    return unique.size();
  }
}
