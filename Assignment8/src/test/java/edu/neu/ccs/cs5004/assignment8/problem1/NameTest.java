package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.assignment8.problem2.Crash;
import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jackie","Wang");
  }

  @Test
  public void getFirstName() {
    assertEquals("Jackie", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Wang", name.getLastName());
  }

  @Test
  public void equals() {
    Name same = new Name("Jackie","Wang");
    Name copy = name;
    Name another = copy;
    assertTrue(name.equals(name));
    assertTrue(name.equals(same));
    assertTrue(name.equals(copy));
    assertTrue(name.equals(another));
    assertFalse(name.equals(null));
    assertFalse(name.equals(1));

    Name diffFirstName = new Name("Peter","Wang");
    Name diffLastName = new Name("Jackie","Smith");
    assertFalse(name.equals(diffFirstName));
    assertFalse(name.equals(diffLastName));

  }

  @Test
  public void testHashCode() {
    Name same = new Name("Jackie","Wang");
    assertTrue(name.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Jackie Wang",name.toString());
  }
}