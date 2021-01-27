package edu.neu.ccs.cs5004.assignment8.problem2;

import static edu.neu.ccs.cs5004.assignment8.problem2.MovingViolation.RecklessDriving;
import static edu.neu.ccs.cs5004.assignment8.problem2.MovingViolation.Speeding;
import static edu.neu.ccs.cs5004.assignment8.problem2.NonMovingViolation.ParkingViolation;
import static edu.neu.ccs.cs5004.assignment8.problem2.NonMovingViolation.VehicleProblem;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AcceptedDriversPoolTest {

  // the pool to store accepted drivers
  AcceptedDriversPool testPool;

  // a prospective driver and his related fields for application files
  ProspectiveDriver applicantPeter;
  Name peterFullName;
  Date peterDOB;
  DriverLicense peterDriverLicense;
  Date peterInsuranceDate;
  Date peterDLExpiration;
  Date peterDLIssueDate;
  Vehicle peterCar;
  Vehicle peterCar2;
  List<Name> otherDrivers;
  Date peterVehicleInsuranceExpiration;
  VehicleInsurance peterCarInsurance;
  DriverHistory peterDriverHistory;
  VehicleHistory peterCarHistory;
  Date today;
  Calendar cal;

  // for bad test case
  ProspectiveDriver applicantBadTest;
  Name badFullName;
  Date badDOB;
  DriverLicense badDriverLicense;
  Date badInsuranceDate;
  Date badDLExpiration;
  Date badDLIssueDate;
  Vehicle badCar;
  List<Name> badOtherDrivers;
  Date badVehicleInsuranceExpiration;
  VehicleInsurance badCarInsurance;
  DriverHistory badDriverHistory;
  VehicleHistory badCarHistory;

  @Before
  public void setUp() throws Exception {
    // create an empty AcceptedDriversPool.
    testPool = new AcceptedDriversPool();

    // get today's date from java
    cal = Calendar.getInstance();
    today = new Date(cal.get(Calendar.DATE), cal.get(Calendar.MONTH),
        cal.get(Calendar.YEAR));
    // peter's name and date of birth
    peterFullName = new Name("Peter", "Smith");
    peterDOB = new Date(14, 12, 1987);

    // peter's driver license
    peterInsuranceDate = new Date(10, 8, 2015);
    peterDLExpiration = new Date(10, 8, 2020);
    peterDLIssueDate = new Date(10, 8, 2017);
    peterDriverLicense = new DriverLicense("XH**12345", peterFullName,
        "1727 25th ave s", peterDOB, "US", peterInsuranceDate,
        peterDLExpiration, peterDLIssueDate);
    // peter's vehicle
    peterCar = new Vehicle("Benz C300", peterFullName, 2016);
    peterCar2 = new Vehicle("HONDA CRV", peterFullName, 2015);

    // peter's vehicle insurance
    otherDrivers = new ArrayList<Name>();
    otherDrivers.add(new Name("Ming","Zane"));
    otherDrivers.add(new Name("Roy", "Chen"));
    peterVehicleInsuranceExpiration = new Date(20, 12, 2019);
    peterCarInsurance = new VehicleInsurance(peterFullName, otherDrivers,
        peterVehicleInsuranceExpiration);

    // peter's driver history
    peterDriverHistory = new DriverHistory(new Date (11, 10, 2018),
        null, ParkingViolation);

    // peter vehicle history
    peterCarHistory = new VehicleHistory(Crash.InvolvingBodilyInjuries, peterFullName,
        new Date(25, 9, 2016), null,null);
    // peter as the prospective driver
    applicantPeter = new ProspectiveDriver(peterFullName, peterDOB,
        peterDriverLicense, peterCar, peterCarInsurance,
        peterDriverHistory, peterCarHistory);

    // bad testcase

    badFullName = new Name("bad", "test");
    badDOB = new Date(14, 12, 2011);
    badInsuranceDate = new Date(10, 8, 2015);
    badDLExpiration = new Date(10, 1, 2019);
    badDLIssueDate = new Date(30, 11, 2018);
    badDriverLicense = new DriverLicense("XH**12345", badFullName,
        "1727 25th ave s", badDOB, "CHN", badInsuranceDate,
        badDLExpiration, badDLIssueDate);
    // bad vehicle
    badCar = new Vehicle("Benz C300", badFullName, 1996);
    // bad vehicle insurance
    badOtherDrivers = new ArrayList<Name>();
    badVehicleInsuranceExpiration = new Date(20, 12, 2017);
    badCarInsurance = new VehicleInsurance(new Name("not","peter"), badOtherDrivers,
        badVehicleInsuranceExpiration);
    // bad driver history
    badDriverHistory = new DriverHistory(new Date (11, 10, 2018),
        Speeding, ParkingViolation);
    badDriverHistory = new DriverHistory(new Date (11, 10, 2018),
        Speeding, ParkingViolation);
    badDriverHistory = new DriverHistory(new Date (11, 10, 2018),
        Speeding, ParkingViolation);

    // bad vehicle history
    badCarHistory = new VehicleHistory(Crash.FenderBender, peterFullName,
        new Date(25, 9, 2016), RecklessDriving,
        VehicleProblem);
    // bad application info with nothing matching the provided prospective driver info
    applicantBadTest = new ProspectiveDriver(new Name("Different","name"), new Date(4, 11, 2010),
        badDriverLicense, badCar, badCarInsurance,
        badDriverHistory, badCarHistory);

  }

  @Test
  public void addToPool() {
    testPool.addToPool(applicantPeter);
    assertTrue(testPool.getDriverToVehicle().containsKey(applicantPeter));
    assertTrue(testPool.getDriverToVehicle().get(applicantPeter).contains(peterCar));
  }

  @Test
  public void failToAddToPool() {
    testPool.addToPool(applicantBadTest);
    assertFalse(testPool.getDriverToVehicle().containsKey(applicantBadTest));
  }

  @Test
  public void addToPoolWithAnotherCar() {
    testPool.addToPool(applicantPeter);
    assertTrue(testPool.getDriverToVehicle().containsKey(applicantPeter));
    assertTrue(testPool.getDriverToVehicle().get(applicantPeter).contains(peterCar));
    // same applicant with another car
    ProspectiveDriver applicantPeter2 = new ProspectiveDriver(peterFullName, peterDOB,
        peterDriverLicense, peterCar2, peterCarInsurance,
        peterDriverHistory, peterCarHistory);
    // make new application
    testPool.addToPool(applicantPeter2);
    assertTrue(testPool.getDriverToVehicle().containsKey(applicantPeter2));
    assertTrue(testPool.getDriverToVehicle().get(applicantPeter2).contains(peterCar2));
    // old applicant and old vehicle still in the pool
    assertTrue(testPool.getDriverToVehicle().containsKey(applicantPeter));
    assertTrue(testPool.getDriverToVehicle().get(applicantPeter).contains(peterCar));

  }

}