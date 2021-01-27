package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ProspectiveDriverTest {
  private ProspectiveDriver prospectiveDriver;
  private Name name;
  private Date dateOfBirth;
  private Date licenseIssuance;
  private Date licenseExpiration;
  private List<Name> otherPeople;
  private Date insuranceExpiration;
  private Date dateOfViolation;
  private Date issueDate;
  private DriverLicense driverLicense;
  private Vehicle vehicle;
  private VehicleInsurance vehicleInsurance;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
    dateOfBirth = new Date(10, 3, 1995);
    licenseIssuance = new Date(10, 10, 2015);
    licenseExpiration = new Date(10, 10, 2020);
    otherPeople = new ArrayList<>();
    otherPeople.add(new Name("Ming", "Zhang"));
    insuranceExpiration = new Date(25, 8, 2019);
    dateOfViolation = new Date(28, 1, 2018);
    issueDate = new Date(10,10,2017);
    driverLicense = new DriverLicense("XU**1234", name, "1727 25th ave s",
        dateOfBirth, "US", licenseIssuance, licenseExpiration, issueDate);
    vehicle = new Vehicle("Benz C300", name, 2016);
    vehicleInsurance = new VehicleInsurance(name, otherPeople, insuranceExpiration);
    driverHistory = new DriverHistory(dateOfViolation, MovingViolation.RecklessDriving,
        null);
    vehicleHistory = new VehicleHistory(Crash.WithoutBodilyInjuries, name, dateOfViolation,
        MovingViolation.RecklessDriving, null);
    prospectiveDriver = new ProspectiveDriver(name, dateOfBirth, driverLicense, vehicle, vehicleInsurance,
        driverHistory, vehicleHistory);
  }

  @Test
  public void getName() {
    assertEquals(name, prospectiveDriver.getName());
  }

  @Test
  public void getDateOfBirth() {
    assertEquals(dateOfBirth, prospectiveDriver.getDateOfBirth());
  }

  @Test
  public void getDriverLicense() {
    assertEquals(driverLicense, prospectiveDriver.getDriverLicense());
  }

  @Test
  public void getVehicle() {
    assertEquals(vehicle, prospectiveDriver.getVehicle());
  }

  @Test
  public void getVehicleInsurance() {
    assertEquals(vehicleInsurance, prospectiveDriver.getVehicleInsurance());
  }

  @Test
  public void getDriverHistory() {
    assertEquals(driverHistory, prospectiveDriver.getDriverHistory());
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(vehicleHistory, prospectiveDriver.getVehicleHistory());
  }

  @Test
  public void getDriverAge() {
    assertEquals(new Integer(24),
        prospectiveDriver.getAge());
  }

  @Test
  public void equals() {
    ProspectiveDriver copy = prospectiveDriver;
    ProspectiveDriver same = new ProspectiveDriver(name, dateOfBirth,
        driverLicense, vehicle, vehicleInsurance,
        driverHistory, vehicleHistory);
    ProspectiveDriver another = copy;
    assertTrue(prospectiveDriver.equals(copy));
    assertTrue(prospectiveDriver.equals(same));
    assertTrue(prospectiveDriver.equals(another));
    assertFalse(prospectiveDriver.equals(null));
    assertFalse(prospectiveDriver.equals(vehicleHistory));

  }

  @Test
  public void testHashCode() {
    ProspectiveDriver copy = prospectiveDriver;
    assertTrue(prospectiveDriver.hashCode() == copy.hashCode());
  }


  @Test
  public void testToString() {
    assertEquals("Driver{name=Name{firstName='Hao', lastName='Xu'}, "
        + "dateOfBirth=Date{day=10, month=3, year=1995}, driverLicense=XU**1234}",
        prospectiveDriver.toString());
  }

}