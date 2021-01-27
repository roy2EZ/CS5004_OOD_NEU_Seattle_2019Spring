package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YearTest {
  private Year year;

  @Before
  public void setUp() throws Exception {
    year = new Year(2019);
  }

  @Test
  public void getYear() {
    assertEquals(2019, year.getYear());
  }

  @Test
  public void setYear() throws IllegalYearException {
    year.setYear(2015);
    assertEquals(2015, year.getYear());
  }

  @Test(expected = IllegalYearException.class)
  public void setBadYear1() throws IllegalYearException {
    year.setYear(0);
  }

  @Test(expected = IllegalYearException.class)
  public void setBadYear2() throws IllegalYearException {
    year.setYear(10000);
  }

  @Test
  public void equals() throws IllegalYearException {
    Year same = new Year(2019);
    Year copy = year;
    Year another = copy;
    assertTrue(year.equals(year));
    assertTrue(year.equals(same));
    assertTrue(year.equals(copy));
    assertTrue(year.equals(another));
    assertFalse(year.equals(null));
    assertFalse(year.equals(1));
    assertFalse(year.equals(new Year(1987)));
  }

  @Test
  public void testHashCode() {
    Year copy = year;
    assertTrue(year.hashCode() == copy.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("2019", year.toString());
  }
}