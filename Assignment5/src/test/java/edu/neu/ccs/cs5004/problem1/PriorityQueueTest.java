package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * test the PQ
 *
 *  @author Rongyi Chen
 *  @version 1.0
 */
public class PriorityQueueTest {
  PriorityQueue testPQ;
  Element e1;
  Element e2;
  Element e3;
  Element e4;
  Element e5;

  @Before
  public void setUp() throws Exception {
    e1 = new Element(10,"I");
    e2 = new Element(25,"love");
    e3 = new Element(38,"java");
    e4 = new Element(46,"very");
    e5 = new Element(57,"much");
    testPQ = new PriorityQueue(5);
  }

  @Test
  public void isEmpty() {
    assertTrue(testPQ.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, testPQ.size());
    testPQ.insert(e1);
    assertEquals(1, testPQ.size());
    testPQ.insert(e2);
    assertEquals(2, testPQ.size());
    testPQ.removeHighest();
    assertEquals(1, testPQ.size());
    testPQ.removeHighest();
    assertEquals(0, testPQ.size());
  }

  @Test
  public void isFull() {
    assertFalse(testPQ.isFull());
    testPQ.insert(e1);
    testPQ.insert(e2);
    testPQ.insert(e3);
    assertFalse(testPQ.isFull());
    testPQ.insert(e4);
    testPQ.insert(e5);
    assertTrue(testPQ.isFull());
  }

  @Test
  public void insert() {
    assertEquals(0, testPQ.size());
    testPQ.insert(e1);
    assertEquals(1, testPQ.size());
    testPQ.insert(e2);
    assertEquals(2, testPQ.size());
  }

  @Test
  public void removeHighest() {
    assertEquals(0, testPQ.size());
    // insert elements into the PQ, with random order
    testPQ.insert(e4);
    testPQ.insert(e5);
    testPQ.insert(e2);
    testPQ.insert(e3);
    testPQ.insert(e1);
    assertEquals(e5, testPQ.removeHighest());
    assertEquals(e4, testPQ.removeHighest());
    assertEquals(e3, testPQ.removeHighest());
    assertEquals(e2, testPQ.removeHighest());
    assertEquals(e1, testPQ.removeHighest());
    assertNull(testPQ.removeHighest());
  }



  @Test
  public void pop() throws EmptyQueueException {
    assertEquals(0, testPQ.size());
    // insert elements into the PQ, with random order
    testPQ.insert(e2);
    testPQ.insert(e3);
    testPQ.insert(e1);
    // restore a new PQ as result after testPQ calling pop()
    PriorityQueue actualPQ1 = testPQ.pop();
    assertEquals(2, actualPQ1.size());
    // do it again to see if another element pop out
    PriorityQueue actualPQ2 = testPQ.pop();
    assertEquals(1, actualPQ1.size());
  }

  @Test
  public void add() {
    testPQ.add(104,"Hello");
    testPQ.add(79,"World");
    testPQ.add(62,"!");
    assertEquals(new Integer(104), testPQ.getArray()[1].priority);
    assertEquals("Hello", testPQ.getArray()[1].value);
    assertEquals(new Integer(79), testPQ.getArray()[2].priority);
    assertEquals("World", testPQ.getArray()[2].value);
    assertEquals(new Integer(62), testPQ.getArray()[3].priority);
    assertEquals("!", testPQ.getArray()[3].value);
  }

  @Test
  public void getArray() {
  }

  @Test
  public void peek() throws EmptyQueueException {
    testPQ.insert(e4);
    assertEquals("very", testPQ.peek());
    testPQ.insert(e5);
    assertEquals("much", testPQ.peek());
  }

  @Test
  public void testCreateEmpty() {
    PriorityQueue newEmpty = testPQ.createEmpty(6);
    assertEquals(0, newEmpty.size());
    assertEquals(6, newEmpty.getMaxN());
  }
}