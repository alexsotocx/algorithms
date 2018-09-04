package CodeForces.c1029;

import java.util.Scanner;

public class A {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();
    StringBuilder sb = new StringBuilder();
    int i;
    int j = 0;
    if (n != 1) {
      for(i= 0; i < n/2; i++) {
        if(s.charAt(i) != s.charAt(n-1 -i)) break;
      }
      StringBuilder sbt = new StringBuilder();
      for(j = 0; j < i; j++) {
        if(s.charAt(0) != s.charAt(n - i + j)) sbt.append(s.charAt(n - i + j));
        else break;
      }
      sb.append(s);
      String middle = sbt.toString();
      String toAdd = middle + s.substring(i);
      k--;
      while(k-- > 0) sb.append(toAdd);
    } else {
      while(k-- > 0) sb.append(s);
    }
    System.out.println(sb.toString());
  }
}
