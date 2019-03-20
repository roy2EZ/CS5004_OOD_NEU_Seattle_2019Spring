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
  public void testDrive() {
    TripReport newReport = FleetManager.drive(dist, testCar);
    assertEquals(testCar, newReport.getVehicle());
    assertEquals(dist, newReport.getDist());
    assertEquals(aveSpeed, newReport.getSpeedMilePerMin());
    assertEquals(new Integer(29), newReport.getDurationInMin());
  }
}