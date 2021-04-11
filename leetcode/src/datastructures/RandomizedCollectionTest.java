package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedCollectionTest {

  @Test
  void insert() {
    RandomizedCollectionHash ds = new RandomizedCollectionHash();
    assertTrue(ds.insert(10));
    assertTrue(ds.insert(30));
    assertFalse(ds.insert(10));
    assertTrue(ds.insert(20));
    assertFalse(ds.insert(30));
    assertFalse(ds.insert(20));

    assertTrue(ds.remove(10));
    assertTrue(ds.remove(10));
    assertTrue(ds.remove(30));
    assertTrue(ds.remove(30));

    assertEquals(20, ds.getRandom());
  }
}
