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

  @Test
  public void containsAll() {
    testList.add("I");
    testList.add("really");
    testList.add("love");
    testList.add("Java");
    testList.add("very");
    testList.add("much");

    ListOfStrings anotherList = new ListOfStrings();
    anotherList.add("I");
    anotherList.add("love");
    anotherList.add("Java");
    assertTrue(testList.containsAll(anotherList));

    ListOfStrings notContainsList = new ListOfStrings();
    notContainsList.add("I");
    notContainsList.add("hate");
    notContainsList.add("C");
    assertFalse(testList.containsAll(notContainsList));

  }

  @Test
  public void filterLagerThan() {
    testList.add("I");
    testList.add("really");
    testList.add("love");
    testList.add("Java");
    testList.add("a");
    testList.add("lot");

    assertEquals(1,testList.filterLagerThan(5).size());
    assertTrue(testList.filterLagerThan(5).contains("really"));
    assertEquals(3,testList.filterLagerThan(4).size());
    assertTrue(testList.filterLagerThan(4).contains("really"));
    assertTrue(testList.filterLagerThan(4).contains("love"));
    assertTrue(testList.filterLagerThan(4).contains("Java"));
    assertFalse(testList.filterLagerThan(4).contains("I"));

  }

  @Test
  public void hasDuplicates() {
    assertFalse(testList.hasDuplicates()); // empty list has not duplicates
    testList.add("1");
    testList.add("2");
    testList.add("3");
    testList.add("4");
    testList.add("1");
    testList.add("3");
    assertEquals("[1,2,3,4,1,3]", testList.toString());
    assertTrue(testList.hasDuplicates()); // list has duplicates
    testList.removeLast(); // remove the last string "3"
    assertEquals("[1,2,3,4,1]", testList.toString());
    assertTrue(testList.hasDuplicates()); // list still has duplicates
    testList.removeFirst(); // remove the first string "1"
    assertEquals("[2,3,4,1]", testList.toString());
    assertFalse(testList.hasDuplicates()); // list has no duplicates
  }

  @Test
  public void removeDuplicates() {
    // if list is empty, removeDuplicates() do nothing
    assertEquals(testList, testList.removeDuplicates());
    testList.add("1");
    testList.add("2");
    testList.add("3");
    testList.add("4");
    // if list has no duplicates, removeDuplicates() do nothing
    assertEquals(testList, testList.removeDuplicates());

    // Add one duplicated element
    testList.add("1");
    assertEquals("[1,2,3,4,1]", testList.toString());
    // the removeDuplicates() method should return a list with the duplicate element removed;
    testList.removeDuplicates();
    assertEquals("[1,2,3,4]", testList.toString());

    // Add two duplicated elements
    testList.add("4");
    testList.add("1");
    assertEquals("[1,2,3,4,4,1]", testList.toString());
    // remove the duplicated elements
    testList.removeDuplicates();
    assertEquals("[1,2,3,4]", testList.toString());

  }

  @Test
  public void indexOf() {
    testList.add("I");
    testList.add("really");
    testList.add("love");
    testList.add("Java");
    testList.add("a");
    testList.add("lot");
    assertEquals(0,testList.indexOf("I"));
    assertEquals(1,testList.indexOf("really"));
    assertEquals(2,testList.indexOf("love"));
    assertEquals(3,testList.indexOf("Java"));
    assertEquals(4,testList.indexOf("a"));
    assertEquals(5,testList.indexOf("lot"));

  }



  @Test
  public void equals() {
    testList.add("I");
    testList.add("really");
    testList.add("love");
    testList.add("Java");
    ListOfStrings testList2 = new ListOfStrings();
    testList2.add("I");
    testList2.add("really");
    testList2.add("love");
    testList2.add("Java");
    assertTrue(testList.equals(testList2));

    testList2.remove(3);
    assertFalse(testList.equals(testList2));
  }

  @Test
  public void removeIndex() {
    testList.add("I");
    testList.add("really");
    testList.add("love");
    testList.add("Java");
    testList.add("a");
    testList.add("lot");

    assertEquals("love", testList.remove(2));
    // after testList[2] is removed, "lot" became testList[4]
    assertEquals("lot", testList.remove(4));
  }
}