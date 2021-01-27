package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date(30, 3, 2019);
  }

  @Test
  public void getDay() {
    assertEquals(30, date.getDay());
  }

  @Test
  public void getMonth() {
    assertEquals(3, date.getMonth());
  }

  @Test
  public void getYear() {
    assertEquals(2019, date.getYear());
  }
}