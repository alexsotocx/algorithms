package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    @Test
    void put() {
      LFUCache cache = new LFUCache( 2 /* capacity */ );

      cache.put(3, 1);
      cache.put(2, 1);
      cache.put(2, 2);
      cache.put(4, 4);
      assertEquals(2, cache.get(2));
      assertEquals(-1, cache.get(3));
      assertEquals(4, cache.get(4));
    }
}
