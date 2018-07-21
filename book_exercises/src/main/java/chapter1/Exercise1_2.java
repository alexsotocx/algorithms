package chapter1;

/*
Given two string determine if one is permutation of the other
* */
public class Exercise1_2 {
  boolean isPermutation(String a, String b) {
    if (a.length() != b.length()) return false;
    int[] cCount = new int[256];
    for (int i = 0; i < a.length(); i++) cCount[a.charAt(i)]++;
    for (int i = 0; i < b.length(); i++) {
      if (cCount[b.charAt(i)] == 0) return false;
      cCount[b.charAt(i)]--;
    }
    return true;
  }
}