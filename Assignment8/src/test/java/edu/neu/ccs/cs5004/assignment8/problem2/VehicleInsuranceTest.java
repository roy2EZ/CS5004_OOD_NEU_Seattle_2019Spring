package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceTest {
  private VehicleInsurance vehicleInsurance;
  private Name name;
  private List<Name> otherDriver;
  private Date expiration;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
    otherDriver = new ArrayList<Name>();
    otherDriver.add(new Name("Ming","Zane"));
    otherDriver.add(new Name("Peter", "Smith"));
    expiration = new Date(20, 12, 2019);
    vehicleInsurance = new VehicleInsurance(name, otherDriver, expiration);
  }

  @Test
  public void getOwner() {
    assertEquals(name, vehicleInsurance.getOwner());
  }

  @Test
  public void getOtherDrivers() {
    assertEquals(new Name("Ming","Zane"), vehicleInsurance.getOtherDrivers().get(0));
    assertEquals(new Name("Peter", "Smith"), vehicleInsurance.getOtherDrivers().get(1));
  }

  @Test
  public void getExpiration() {
    assertEquals(expiration, vehicleInsurance.getExpiration());
  }

  @Test
  public void testToString() {
    assertEquals("VehicleInsurance{owner name: Hao Xu, 2 otherDrivers, expiration date: 2019/12/20}",
        vehicleInsurance.toString() );
  }

  @Test
  public void equals() {
    VehicleInsurance copy = vehicleInsurance;
    VehicleInsurance same = new VehicleInsurance(name, otherDriver, expiration);
    VehicleInsurance another = copy;
    assertTrue(vehicleInsurance.equals(copy));
    assertTrue(vehicleInsurance.equals(same));
    assertTrue(vehicleInsurance.equals(another));
    assertFalse(vehicleInsurance.equals(null));
    assertFalse(vehicleInsurance.equals(name));
    // test not equal
    Name name2 = new Name("Ha", "Yu");
    List<Name> otherDriver2 = new ArrayList<Name>();
    otherDriver2.add(new Name("a","c"));
    otherDriver2.add(new Name("b", "d"));
    Date expiration2 = new Date(2, 1, 2010);
    VehicleInsurance diff1 = new VehicleInsurance(name2, otherDriver, expiration);
    VehicleInsurance diff2 = new VehicleInsurance(name, otherDriver2, expiration);
    VehicleInsurance diff3 = new VehicleInsurance(name, otherDriver, expiration2);
    assertFalse(vehicleInsurance.equals(diff1));
    assertFalse(vehicleInsurance.equals(diff2));
    assertFalse(vehicleInsurance.equals(diff3));
  }

}