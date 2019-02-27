package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {

  private BagOfWords tedBag;

  @Before
  public void setUp() throws Exception {
    tedBag = new BagOfWords();
  }

  @Test
  public void emptyBagOfWords() {
    BagOfWords empty = tedBag.emptyBagOfWords();
    assertTrue(empty.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(tedBag.isEmpty());
  }

  /**
   * Test size() method, also test add and remove related methods
   */
  @Test
  public void size() {
    assertEquals(0, tedBag.size());
    tedBag.add("I");
    assertEquals(1, tedBag.size());
    tedBag.add("love");
    assertEquals(2, tedBag.size());
    tedBag.add("Java");
    assertEquals(3, tedBag.size());

    // also test the remove related method
    tedBag.removeLast();
    assertEquals(2, tedBag.size());
    tedBag.removeFirst();
    assertEquals(1, tedBag.size());
    tedBag.remove(0);
    assertEquals(0, tedBag.size());

  }

  /**
   * Test different add related methods,
   * also test get related methods.
   */
  @Test
  public void add() {
    tedBag.add("I");
    assertEquals("I", tedBag.getLast());
    tedBag.add(1,"love");
    assertEquals("love", tedBag.get(1));
    tedBag.addFirst("Java");
    assertEquals("Java", tedBag.getFirst());
    tedBag.addLast("Do");
    assertEquals("Do", tedBag.getLast());
    
  }

  /**
   * Test contains() method, also test the constructor.
   */
  @Test
  public void contains() {
    BagOfWords testBag = new BagOfWords(new String[]{"I","love","Java"});
    assertTrue(testBag.contains("Java"));
    assertTrue(testBag.contains("love"));
    assertTrue(testBag.contains("I"));
    assertFalse(testBag.contains("you"));

  }

}