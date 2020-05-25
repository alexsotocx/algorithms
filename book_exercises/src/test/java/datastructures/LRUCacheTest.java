package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {

  @Test
  void get() {
//    ["LRUCache","put","put","put","put","get","get"]
//    [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    LRUCache cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(2));
  }
}
