package edu.neu.ccs.cs5004.prob1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  Vehicle testCar;
  Float aveSpeed;
  Float maxSpeed;
  Float dist;

  @Before
  public void setUp() throws Exception {
    dist = new Float(1893.5);
    aveSpeed = new Float(65.0);
    maxSpeed = new Float(195.0);
    testCar = new Vehicle("BJD1601", aveSpeed, maxSpeed );
  }

  @Test
  public void testDrive1() {
    TripReport newReport = FleetManager.drive(dist, testCar);
    assertEquals(testCar, newReport.getVehicle());
    assertEquals(dist, newReport.getDist());
    assertEquals(aveSpeed, newReport.getSpeedMilePerMin());
    assertEquals(new Integer(29), newReport.getDurationInMin());
  }

  @Test
  public void testDrive2() {
    TripReport newReport = FleetManager.drive(dist, aveSpeed, maxSpeed, "WBE2864");
    assertEquals("WBE2864",newReport.getVehicle().getID());
    assertEquals(aveSpeed,newReport.getVehicle().getAveSpeed());
    assertEquals(maxSpeed,newReport.getVehicle().getMaxSpeed());
    assertEquals(dist,newReport.getDist());
    assertEquals(aveSpeed,newReport.getSpeedMilePerMin());
    assertEquals(new Integer(29),newReport.getDurationInMin());

  }


  @Test
  public void testDrive3() {
    TripReport newReport = FleetManager.drive(29, dist, "OKM2837", maxSpeed);
    assertEquals("OKM2837",newReport.getVehicle().getID());
    assertEquals(Math.round(aveSpeed),Math.round(newReport.getVehicle().getAveSpeed()));
    assertEquals(maxSpeed,newReport.getVehicle().getMaxSpeed());
    assertEquals(Math.round(aveSpeed),Math.round(newReport.getSpeedMilePerMin()));
    assertEquals(dist,newReport.getDist());
    assertEquals(new Integer(29),newReport.getDurationInMin());
  }
}