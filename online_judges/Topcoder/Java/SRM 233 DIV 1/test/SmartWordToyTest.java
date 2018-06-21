import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartWordToyTest {

  @Test(timeout = 2000)
  public void test0() {
    String start = "aaaa";
    String finish = "zzzz";
    String[] forbid = new String[]{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"};
    assertEquals(8, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test1() {
    String start = "aaaa";
    String finish = "bbbb";
    String[] forbid = new String[]{};
    assertEquals(4, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test2() {
    String start = "aaaa";
    String finish = "mmnn";
    String[] forbid = new String[]{};
    assertEquals(50, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test3() {
    String start = "aaaa";
    String finish = "zzzz";
    String[] forbid = new String[]{"bz a a a", "a bz a a", "a a bz a", "a a a bz"};
    assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test4() {
    String start = "aaaa";
    String finish = "zzzz";
    String[] forbid = new String[]{"cdefghijklmnopqrstuvwxyz a a a",
        "a cdefghijklmnopqrstuvwxyz a a",
        "a a cdefghijklmnopqrstuvwxyz a",
        "a a a cdefghijklmnopqrstuvwxyz"};
    assertEquals(6, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test5() {
    String start = "aaaa";
    String finish = "bbbb";
    String[] forbid = new String[]{"b b b b"};
    assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test8() {
    String start = "mmma";
    String finish = "yyyy";
    String[] forbid = new String[]{"qwertyuiopasdfg qwertyuiopasdfg qwertyuiopasdfg z", "qwertyuiopasdfg qwertyuiopasdfg hjklzxvcbnm z", "qwertyuiopasdfg hjklzxvcbnm qwertyuiopasdfg z", "qwertyuiopasdfg hjklzxvcbnm hjklzxvcbnm z", "hjklzxvcbnm qwertyuiopasdfg qwertyuiopasdfg z", "hjklzxvcbnm qwertyuiopasdfg hjklzxvcbnm z", "hjklzxvcbnm hjklzxvcbnm qwertyuiopasdfg z", "hjklzxvcbnm hjklzxvcbnm hjklzxvcbnm z", "qwertyuiopasdfg qwertyuiopasdfg z qwertyuiopasdfg", "qwertyuiopasdfg qwertyuiopasdfg z hjklzxvcbnm", "qwertyuiopasdfg hjklzxvcbnm z qwertyuiopasdfg", "qwertyuiopasdfg hjklzxvcbnm z hjklzxvcbnm", "hjklzxvcbnm qwertyuiopasdfg z qwertyuiopasdfg", "hjklzxvcbnm qwertyuiopasdfg z hjklzxvcbnm", "hjklzxvcbnm hjklzxvcbnm z qwertyuiopasdfg", "hjklzxvcbnm hjklzxvcbnm z hjklzxvcbnm", "qwertyuiopasdfg z qwertyuiopasdfg qwertyuiopasdfg", "qwertyuiopasdfg z qwertyuiopasdfg hjklzxvcbnm", "qwertyuiopasdfg z hjklzxvcbnm qwertyuiopasdfg", "qwertyuiopasdfg z hjklzxvcbnm hjklzxvcbnm", "hjklzxvcbnm z qwertyuiopasdfg qwertyuiopasdfg", "hjklzxvcbnm z qwertyuiopasdfg hjklzxvcbnm", "hjklzxvcbnm z hjklzxvcbnm qwertyuiopasdfg", "hjklzxvcbnm z hjklzxvcbnm hjklzxvcbnm", "z qwertyuiopasdfg qwertyuiopasdfg qwertyuiopasdfg", "z qwertyuiopasdfg qwertyuiopasdfg hjklzxvcbnm", "z qwertyuiopasdfg hjklzxvcbnm qwertyuiopasdfg", "z qwertyuiopasdfg hjklzxvcbnm hjklzxvcbnm", "z hjklzxvcbnm qwertyuiopasdfg qwertyuiopasdfg", "z hjklzxvcbnm qwertyuiopasdfg hjklzxvcbnm", "z hjklzxvcbnm hjklzxvcbnm qwertyuiopasdfg", "z hjklzxvcbnm hjklzxvcbnm hjklzxvcbnm", "n ablm ablm abcdefghijkl", "n ablm abcdefghijkl ablm", "n abcdefghijkl ablm ablm", "abcdefghijklm n abcdefghijklm abcdefghijklm", "abcdefghijklm abcdefghijklm n abcdefghijklm", "abcdefghijklm abcdefghijklm abcdefghijklm n", "bcdefghijklm bcdefghijkl ablm ablm", "abcdefghijkl ablm bcdefghijkl ablm", "ablm bcdefghijklm bcdefghijkl ablm", "abcdefghijkl ablm ablm bcdefghijkl", "ablm abcdefghijkl ablm bcdefghijkl", "ablm ablm bcdefghijklm bcdefghijkl"};
    assertEquals(228, new SmartWordToy().minPresses(start, finish, forbid));
  }

  @Test(timeout = 2000)
  public void test6() {
    String start = "zzzz";
    String finish = "aaaa";
    String[] forbid = new String[]{"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
        "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"};
    assertEquals(-1, new SmartWordToy().minPresses(start, finish, forbid));
  }
}
