package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {
  private VehicleHistory vehicleHistory;
  private Name name;
  private Date date;
  // for test not equal
  private Name name2;
  private Date date2;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
    date = new Date(25, 9, 2016);
    vehicleHistory = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date,
        MovingViolation.RecklessDriving,null);
    name2 = new Name("a", "b");
    date2 = new Date(5, 2, 2015);

  }

  @Test
  public void getCrash() {
    assertEquals(Crash.InvolvingBodilyInjuries, vehicleHistory.getCrash());
  }

  @Test
  public void getName() {
    assertEquals(name, vehicleHistory.getName());
  }

  @Test
  public void getDate() {
    assertEquals(date, vehicleHistory.getDate());
  }

  @Test
  public void getMovingViolation() {
    assertEquals(MovingViolation.RecklessDriving, vehicleHistory.getMovingViolation());
  }

  @Test
  public void getNonMovingViolation() {
    assertEquals(null, vehicleHistory.getNonMovingViolation());
  }

  @Test
  public void testToString() {
    assertEquals("VehicleHistory{crash=InvolvingBodilyInjuries, name=Name{firstName='Hao',"
        + " lastName='Xu'}, date=Date{day=25, month=9, year=2016}, MovingViolation=RecklessDriving,"
        + " nonMovingViolation=null}", vehicleHistory.toString());
  }

  @Test
  public void equals() {
    VehicleHistory copy = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date,
        MovingViolation.RecklessDriving,null);
    VehicleHistory same = vehicleHistory;
    VehicleHistory another = copy;

    VehicleHistory diff1 = new VehicleHistory(Crash.FenderBender, name, date,
        MovingViolation.RecklessDriving,null);
    VehicleHistory diff2 = new VehicleHistory(Crash.InvolvingBodilyInjuries, name2, date,
        MovingViolation.RecklessDriving,null);
    VehicleHistory diff3 = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date2,
        MovingViolation.RecklessDriving,null);
    VehicleHistory diff4 = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date,
        MovingViolation.Speeding,null);
    VehicleHistory diff5 = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date,
        MovingViolation.RecklessDriving,NonMovingViolation.ParkingViolation);


    assertTrue(vehicleHistory.equals(vehicleHistory));
    assertTrue(vehicleHistory.equals(copy));
    assertTrue(vehicleHistory.equals(same));
    assertTrue(vehicleHistory.equals(another));
    assertFalse(vehicleHistory.equals(null));
    assertFalse(vehicleHistory.equals(name));
    assertFalse(vehicleHistory.equals(diff1));
    assertFalse(vehicleHistory.equals(diff2));
    assertFalse(vehicleHistory.equals(diff3));
    assertFalse(vehicleHistory.equals(diff4));
    assertFalse(vehicleHistory.equals(diff5));

  }

  @Test
  public void testHashCode() {
    VehicleHistory copy = new VehicleHistory(Crash.InvolvingBodilyInjuries, name, date,
        MovingViolation.RecklessDriving,null);
    assertTrue(vehicleHistory.hashCode() == copy.hashCode());
  }
}