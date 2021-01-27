package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {
  private DriverHistory driverHistory;
  private Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date(28, 1, 2018);
    driverHistory = new DriverHistory(date, MovingViolation.RecklessDriving, null);
  }

  @Test
  public void getDate() {
    assertEquals(date, driverHistory.getDate());
  }

  @Test
  public void getMovingViolation() {
    assertEquals(MovingViolation.RecklessDriving, driverHistory.getMovingViolation());
  }

  @Test
  public void getNonMovingViolation() {
    assertEquals(null, driverHistory.getNonMovingViolation());
  }

  @Test
  public void testToString() {
    assertEquals("DriverHistory{date =2018/1/28, MovingViolation = RecklessDriving, nonMovingViolation = null}", driverHistory.toString());
  }

  @Test
  public void equals() {
    DriverHistory copy = driverHistory;
    DriverHistory same = new DriverHistory(date, MovingViolation.RecklessDriving, null);
    DriverHistory another = copy;
    assertTrue(driverHistory.equals(copy));
    assertTrue(driverHistory.equals(same));
    assertTrue(driverHistory.equals(another));
    assertFalse(driverHistory.equals(null));
    assertFalse(driverHistory.equals(date));
    // test not equal
    Date date2 = new Date(1,1,2011);
    DriverHistory diff1 = new DriverHistory(date2, MovingViolation.RecklessDriving, null);
    DriverHistory diff2 = new DriverHistory(date, MovingViolation.Speeding, null);
    DriverHistory diff3 = new DriverHistory(date, MovingViolation.RecklessDriving, NonMovingViolation.ParkingViolation);
    assertFalse(driverHistory.equals(diff1));
    assertFalse(driverHistory.equals(diff2));
    assertFalse(driverHistory.equals(diff3));

  }

}