package hashTabels;

import org.junit.Test;

import static org.junit.Assert.*;


public class HashTableTest {

  @Test
  public void declaringHashTableTest() {
    HashTable<String, Integer> ht = new HashTable<String, Integer>();
    assertEquals("There was a problem in size method when the size is must be zero at the begging", 0, ht.size());
    assertEquals("There was a problem in the capacity of hashtable", 1, ht.capacity());
    assertEquals("There was problem in toString method", "{}", ht.toString());
  }

  @Test
  public void additionTest() {
    HashTable<String, Integer> ht = new HashTable<String, Integer>();
    ht.add("a", 1);
    ht.add("b", 2);
    ht.add("c", 3);
    assertEquals("There was a problem in addition method when the size is must be three", 3, ht.size());
    ht.add("d", 4);
    ht.add("e", 5);
    assertEquals("The size should be 5", 5, ht.size());
  }

  @Test
  public void getTest() {
    HashTable<String, Integer> ht = new HashTable<String, Integer>();
    ht.add("a", 1);
    ht.add("b", 2);
    ht.add("c", 3);
    assertEquals("The value of a should be 1", (Integer) 1, ht.get("a"));
    assertEquals("The value of b should be 2", (Integer) 2, ht.get("b"));
    assertEquals("The value of c should be 3", (Integer) 3, ht.get("c"));
  }

  @Test
  public void capacityTest() {
    HashTable<String, Integer> ht = new HashTable<String, Integer>();
    ht.add("a", 1);
    ht.add("b", 2);
    ht.add("c", 3);
    ht.add("d", 4);
    ht.add("e", 5);
    assertEquals("The capacity should be 8", 8, ht.capacity());
  }

  @Test
  public void containTest () {
    HashTable<String, Integer> ht = new HashTable<String, Integer>();
    ht.add("a", 1);
    ht.add("b", 2);
    ht.add("c", 3);
    ht.add("d", 4);
    ht.add("e", 5);
    assertTrue("The contain method should return true", ht.contains("a"));
    assertFalse("The contain method should return false", ht.contains("f"));
  }


}
