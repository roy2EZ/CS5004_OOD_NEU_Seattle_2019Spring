package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private Vehicle vehicle;
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
    vehicle = new Vehicle("Benz C300", name, 2016);
  }

  @Test
  public void getMakeAndModel() {
    assertEquals("Benz C300", vehicle.getMakeAndModel());
  }

  @Test
  public void getOwner() {
    assertEquals(name, vehicle.getOwner());
  }

  @Test
  public void getYear() {
    assertEquals(2016, vehicle.getYear());
  }
}