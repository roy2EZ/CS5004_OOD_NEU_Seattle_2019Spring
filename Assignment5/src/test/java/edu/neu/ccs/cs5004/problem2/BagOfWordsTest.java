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

  @Test
  public void size() {
    assertEquals(0, tedBag.size());
    tedBag.add("I");
    assertEquals(1, tedBag.size());
    tedBag.add("love");
    assertEquals(2, tedBag.size());
    tedBag.add("Java");
    assertEquals(3, tedBag.size());

  }

  @Test
  public void add() {
    tedBag.add("I");
    assertEquals("I", tedBag.getLast());
    tedBag.add("love");
    assertEquals("love", tedBag.getFirst());
    tedBag.add("Java");
    assertEquals("Java", tedBag.get(0));
  }

  @Test
  public void contains() {
    tedBag.add("I");
    tedBag.add("love");
    tedBag.add("Java");

    assertTrue(tedBag.contains("I"));
    assertFalse(tedBag.contains("Python"));
  }
}