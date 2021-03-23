package Month30Challenge.FirstWeek;

import org.junit.jupiter.api.Test;

class GroupingAnagramsTest {

  @Test
  void groupAnagrams() {
    System.out.println(new GroupingAnagrams().groupAnagrams(
      new String[]{"abz", "zba", "abzz"}
    ));
  }
}
