package edu.neu.ccs.cs5004.problem2.listOfStrings;

import static org.junit.Assert.*;

import javax.swing.text.TabExpander;
import org.junit.Before;
import org.junit.Test;

public class ListOfStringsTest {
  private ListOfStrings testList;

  @Before
  public void setUp() throws Exception {
    this.testList = new ListOfStrings();

  }

  @Test
  public void isEmpty() {
    assertTrue(testList.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, testList.size());
    testList.addLast("I");
    assertEquals(1, testList.size());
    testList.addLast("love");
    assertEquals(2, testList.size());
    testList.addLast("Java");
    assertEquals(3, testList.size());
  }

  @Test
  public void getFirst() {
    testList.addFirst("I");
    assertEquals("I", testList.getFirst());
    testList.addFirst("love");
    assertEquals("love", testList.getFirst());
    testList.addFirst("Java");
    assertEquals("Java", testList.getFirst());

  }

  @Test
  public void getLast() {
    testList.addLast("I");
    assertEquals("I", testList.getLast());
    testList.addLast("love");
    assertEquals("love", testList.getLast());
    testList.addLast("Java");
    assertEquals("Java", testList.getLast());
  }

  @Test
  public void addFirst() {
    testList.addFirst("I");
    assertEquals("I", testList.getFirst());
    testList.addFirst("love");
    assertEquals("love", testList.getFirst());
    testList.addFirst("Java");
    assertEquals("Java", testList.getFirst());

  }

  @Test
  public void addLast() {
    testList.addLast("I");
    assertEquals("I", testList.getLast());
    testList.addLast("love");
    assertEquals("love", testList.getLast());
    testList.addLast("Java");
    assertEquals("Java", testList.getLast());
  }

  @Test
  public void add() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    testList.add(1, "don't");
    assertEquals("I", testList.get(0));
    assertEquals("don't", testList.get(1));
    assertEquals("love", testList.get(2));
    assertEquals("Java", testList.get(3));
  }

  @Test
  public void get() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertEquals("I", testList.get(0));
    assertEquals("love", testList.get(1));
    assertEquals("Java", testList.get(2));
  }

  @Test
  public void removeFirst() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertEquals("I", testList.getFirst());
    assertEquals("I",testList.removeFirst());

    assertEquals("love", testList.getFirst());
    assertEquals("love",testList.removeFirst());

    assertEquals("Java", testList.getFirst());
    assertEquals("Java", testList.removeFirst());

    assertNull(testList.removeFirst());
  }


  @Test
  public void removeLast() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertEquals("Java", testList.removeLast());
    assertEquals("love", testList.removeLast());
    assertEquals("I", testList.removeLast());


  }

  @Test
  public void remove() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertEquals("love", testList.remove(1));
    assertEquals("I", testList.remove(0));
    assertNull(testList.remove(15));
  }

  @Test
  public void testToString() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertEquals("[I,love,Java]", testList.toString());
  }


  @Test
  public void contains() {
    testList.add("I");
    testList.add("love");
    testList.add("Java");
    assertTrue(testList.contains("I"));
    assertTrue(testList.contains("love"));
    assertTrue(testList.contains("Java"));
    assertFalse(testList.contains("don't"));

  }
}