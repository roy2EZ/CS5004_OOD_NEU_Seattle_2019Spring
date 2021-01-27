package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

public class NameTest {
  private Name name;

  @org.junit.Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
  }

  @org.junit.Test
  public void getFirstName() {
    assertEquals("Hao", name.getFirstName());
  }

  @org.junit.Test
  public void getLastName() {
    assertEquals("Xu", name.getLastName());
  }
}