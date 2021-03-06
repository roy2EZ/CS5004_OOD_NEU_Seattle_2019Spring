package edu.neu.ccs.cs5004.problem1.listOfIntegers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

  private List empty;
  private List oneElement;
  private List twoElements;
  private List threeElements;

  @Before
  public void setUp() throws Exception {
    this.empty = new Empty();
    this.oneElement = new Cons(10, this.empty);
    this.twoElements = new Cons(20, this.oneElement);
    this.threeElements = this.twoElements.add(30);
  }

  @Test
  public void size() throws Exception {
    Assert.assertEquals(this.empty.size(), new Integer(0));
    Assert.assertEquals(this.oneElement.size(), new Integer(1));
    Assert.assertEquals(this.twoElements.size(), new Integer(2));
    Assert.assertEquals(this.threeElements.size(), new Integer(3));
  }

  @Test
  public void testLast() throws Exception {
    Assert.assertEquals(this.threeElements.last(), new Integer(10));
  }

  @Test(expected = InvalidCallException.class)
  public void testLastOnEmpty() throws Exception {
    this.empty.last();
  }

  @Test
  public void testLastOnEmptyWithNoTry() throws Exception {
//        this.empty.last();
  }

  @Test
  public void contains() {
    Assert.assertTrue(this.threeElements.contains(new Integer(20)));
    Assert.assertTrue(this.threeElements.contains(new Integer(10)));
    Assert.assertTrue(this.threeElements.contains(new Integer(30)));
    Assert.assertFalse(this.twoElements.contains(new Integer(30)));
    Assert.assertFalse(this.oneElement.contains(new Integer(20)));
    Assert.assertFalse(this.empty.contains(new Integer(10)));
  }

  @Test
  public void elementAt() throws IndexOutOfBoundsException {
    Assert.assertEquals(new Integer(30), this.threeElements.elementAt(new Integer(0)));
    Assert.assertEquals(new Integer(20), this.threeElements.elementAt(new Integer(1)));
    Assert.assertEquals(new Integer(10), this.threeElements.elementAt(new Integer(2)));

    Assert.assertEquals(new Integer(20), this.twoElements.elementAt(new Integer(0)));
    Assert.assertEquals(new Integer(10), this.twoElements.elementAt(new Integer(1)));

    Assert.assertEquals(new Integer(10), this.oneElement.elementAt(new Integer(0)));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void elementAtInvalidIndex() throws IndexOutOfBoundsException {
    this.threeElements.elementAt(100);
  }

}
