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


  @Test
  public void hasDuplicates() {
    BagOfWords duplicate1 = new BagOfWords(new String[]{"I","love","Java","too"});
    BagOfWords duplicate2 = new BagOfWords(new String[]{"I","love","Java","day","by","day"});

    // call hasDuplicates() on empty bag return false
    assertFalse(tedBag.hasDuplicates());
    // call hasDuplicates() on bag with all unique string elements return false
    assertFalse(duplicate1.hasDuplicates());
    // call hasDuplicates() on bag with duplicated elements return true
    assertTrue(duplicate2.hasDuplicates());

  }

  @Test
  public void numOfDuplicated() {
    BagOfWords duplicateBag = new BagOfWords(new String[]{"Python","C","Java","Java","C","C"});
    assertEquals(1,duplicateBag.numOfDuplicated("Python"));
    assertEquals(2,duplicateBag.numOfDuplicated("Java"));
    assertEquals(3,duplicateBag.numOfDuplicated("C"));
    // for string which is not in the Bag, return 0
    assertEquals(0,duplicateBag.numOfDuplicated("C++"));

  }


  @Test
  public void firstIndexOf() {
    BagOfWords duplicateBag2 = new BagOfWords(new String[]{"Python","C","Java","Java","C","C"});
    assertEquals(0, duplicateBag2.firstIndexOf("Python"));
    assertEquals(1, duplicateBag2.firstIndexOf("C"));
    assertEquals(2, duplicateBag2.firstIndexOf("Java"));
  }

  @Test
  public void removeDuplicates() {
    BagOfWords oldDuplicatedBag = new BagOfWords(
        new String[]{"Python", "C", "Java", "Java", "C", "C"});
    BagOfWords newBag = oldDuplicatedBag.removeDuplicates();

    // the new bag has only 3 elements
    assertEquals(3, newBag.size());
    assertTrue(newBag.contains("Python"));
    assertTrue(newBag.contains("C"));
    assertTrue(newBag.contains("Java"));
    // the new bag is without duplicated elements
    assertFalse(newBag.hasDuplicates());

  }

  @Test
  public void testToString() {
    BagOfWords toStringBag = new BagOfWords(
    new String[]{"Process", "finished", "with", "exit", "code", "0"});
    assertEquals("BagOfWords[Process, finished, with, exit, code, 0]",toStringBag.toString());
    // empty bag calling toString will return "BagOfWords[null]"
    assertEquals("BagOfWords[null]",tedBag.toString());
    // add elements into the empty bag and call toString() to see the change
    tedBag.add("first");
    assertEquals("BagOfWords[first]",tedBag.toString());
    tedBag.addLast("second");
    assertEquals("BagOfWords[first, second]",tedBag.toString());
    tedBag.add(1,"1.5");
    assertEquals("BagOfWords[first, 1.5, second]",tedBag.toString());
    tedBag.remove(2);
    assertEquals("BagOfWords[first, 1.5]",tedBag.toString());




  }
}
