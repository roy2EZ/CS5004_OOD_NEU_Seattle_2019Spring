package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
  PriorityQueue testHeap;
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
    testHeap = new PriorityQueue(5);
  }

  @Test
  public void isEmpty() {
    assertTrue(testHeap.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0,testHeap.size());
    testHeap.add(e1);
    assertEquals(1,testHeap.size());
    testHeap.add(e2);
    assertEquals(2,testHeap.size());
    testHeap.removeHighest();
    assertEquals(1,testHeap.size());
    testHeap.removeHighest();
    assertEquals(0,testHeap.size());
  }

  @Test
  public void isFull() {
    assertFalse(testHeap.isFull());
    testHeap.add(e1);
    testHeap.add(e2);
    testHeap.add(e3);
    assertFalse(testHeap.isFull());
    testHeap.add(e4);
    testHeap.add(e5);
    assertTrue(testHeap.isFull());
  }

  @Test
  public void insert() {
    assertEquals(0,testHeap.size());
    testHeap.add(e1);
    assertEquals(1,testHeap.size());
    testHeap.add(e2);
    assertEquals(2,testHeap.size());
  }

  @Test
  public void removeHighest() {
    assertEquals(0,testHeap.size());
    // add elements into the PQ, with random order
    testHeap.add(e4);
    testHeap.add(e5);
    testHeap.add(e2);
    testHeap.add(e3);
    testHeap.add(e1);
    assertEquals(e5,testHeap.removeHighest());
    assertEquals(e4,testHeap.removeHighest());
    assertEquals(e3,testHeap.removeHighest());
    assertEquals(e2,testHeap.removeHighest());
    assertEquals(e1,testHeap.removeHighest());
    assertNull(testHeap.removeHighest());
  }
}