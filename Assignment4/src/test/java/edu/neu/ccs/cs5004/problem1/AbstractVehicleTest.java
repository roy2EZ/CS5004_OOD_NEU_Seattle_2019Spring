package edu.neu.ccs.cs5004.problem1;

import static edu.neu.ccs.cs5004.problem1.Disabilities.*;
import static edu.neu.ccs.cs5004.problem1.Size.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractVehicleTest {
  private Vehicle smallRegCar;
  private Vehicle medCar;
  private Vehicle largeCar;
  private Vehicle disableCar;


  @Before
  public void setUp() throws Exception {
    smallRegCar = new Vehicle(SMALL, REGULAR);
    medCar = new Vehicle(MEDIUM, REGULAR);
    largeCar = new Vehicle(LARGE, REGULAR);
    disableCar = new Vehicle(SMALL, DISABILITY);
  }

  @Test
  public void getVehicleSize() {
    assertEquals(SMALL, smallRegCar.getVehicleSize());
    assertEquals(MEDIUM, medCar.getVehicleSize());
    assertEquals(LARGE, largeCar.getVehicleSize());
  }

  @Test
  public void getVehicleDisType() {
    assertEquals(REGULAR, largeCar.getVehicleDisType());
    assertEquals(DISABILITY, disableCar.getVehicleDisType());
  }
}