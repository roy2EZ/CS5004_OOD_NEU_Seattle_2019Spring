package edu.neu.ccs.cs5004.assignment8.problem2;

import static edu.neu.ccs.cs5004.assignment8.problem2.NonMovingViolation.*;
import static edu.neu.ccs.cs5004.assignment8.problem2.MovingViolation.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {
  ProspectiveDriver applicantPeter;
  Name peterFullName;
  Date peterDOB;
  DriverLicense peterDriverLicense;
  Date peterInsuranceDate;
  Date peterDLExpiration;
  Date peterDLIssueDate;
  Vehicle peterCar;
  List<Name> otherDrivers;
  Date peterVehicleInsuranceExpiration;
  VehicleInsurance peterCarInsurance;
  DriverHistory peterDriverHistory;
  VehicleHistory peterCarHistory;
  Date today;
  Calendar cal;

  // some bad test case implements for testing false returns
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

    // good test case
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
  public void isAcceptedByCheckingAge() {
    // testcase 1: good age test - age over 21
    assertTrue(RegistrationValidator.isAcceptedByCheckingAge(applicantPeter.getAge()));

    // testcase 2: bad age test - age under 21
    assertFalse(RegistrationValidator.isAcceptedByCheckingAge(applicantBadTest.getAge()));
  }
  // -------------------test Prospective driver’s license information--------------
  @Test
  public void isAcceptedByCheckingDriverLicenseInfo() {
    // good driver license with everything is accepted in driver license info
    assertTrue(RegistrationValidator.isAcceptedByCheckingDriverLicenseInfo(applicantPeter));
    // bad driver license info which not matching provided info
    assertFalse(RegistrationValidator.isAcceptedByCheckingDriverLicenseInfo(applicantBadTest));
  }

  @Test
  public void isNameSameAsLicense() {
    // good testcase: applicant name is same as on driver license
    assertTrue(RegistrationValidator.isNameSameAsLicense(peterFullName, applicantPeter.getName()));
    // bad testcase: applicant name is different as on driver license
    assertFalse(RegistrationValidator.isNameSameAsLicense(badFullName, applicantBadTest.getName()));
  }

  @Test
  public void isDateOfBirthSameAsLicense() {
    // good testcase: applicant date of birth is same as driver license
    assertTrue(RegistrationValidator.isDateOfBirthSameAsLicense(peterDOB,applicantPeter.getDateOfBirth()));
    // bad testcase: applicant date of birth is not same as driver license
    assertFalse(RegistrationValidator.isDateOfBirthSameAsLicense(badDOB,applicantBadTest.getDateOfBirth()));
  }

  @Test
  public void isUSLicense() {
    // good testcase: driver license is US
    assertTrue(RegistrationValidator.isUSLicense(applicantPeter.getDriverLicense().getCountry()));
    // bad testcase: driver license is not US
    assertFalse(RegistrationValidator.isUSLicense(applicantBadTest.getDriverLicense().getCountry()));
  }

  @Test
  public void isDriverLicenseIssuedMoreThan6Month() {
    // good testcase: applicant driver license is issued more than 6 month
    assertTrue(RegistrationValidator.isDriverLicenseIssuedMoreThan6Month(applicantPeter.getDriverLicense().getIssueDate()));
    // bad testcase: applicant driver license is issued less than 6 month
    assertFalse(RegistrationValidator.isDriverLicenseIssuedMoreThan6Month(applicantBadTest.getDriverLicense().getIssueDate()));
  }

  @Test
  public void isDriverLicenseNotExpired() {
    // Good testcase: driver license is not expired:
    assertTrue(RegistrationValidator.isDriverLicenseNotExpired(applicantPeter.getDriverLicense().getExpiration()));
    // Bad testcase: driver license is expired:
    assertFalse(RegistrationValidator.isDriverLicenseNotExpired(applicantBadTest.getDriverLicense().getExpiration()));
  }

  //--------------test Vehicle information--------------
  @Test
  public void isAcceptedByCheckingVehicleYear() {
    // Good testcase: vehicle is within 20 year
    assertTrue(RegistrationValidator.isAcceptedByCheckingVehicleYear(applicantPeter.getVehicle().getYear()));
    // Bad testcase: vehicle is over 20 year
    assertFalse(RegistrationValidator.isAcceptedByCheckingVehicleYear(applicantBadTest.getVehicle().getYear()));
  }

  //--------------Vehicle insurance information--------------
  @Test
  public void isAcceptedByCheckingVehicleInsuranceInfo() {
    // good testcase: applicant pass all checkpoints about vehicle insurance info
    assertTrue(RegistrationValidator.isAcceptedByCheckingVehicleInsuranceInfo(applicantPeter));
    // bad testcase: applicant cannot pass checkpoints about vehicle insurance info
    assertFalse(RegistrationValidator.isAcceptedByCheckingVehicleInsuranceInfo(applicantBadTest));
  }

  @Test
  public void isDriverTheOwnerInInsurance() {
    // good testcase: applicant is the owner of insurance
    assertTrue(RegistrationValidator.isDriverTheOwnerInInsurance(peterFullName, applicantPeter.getVehicleInsurance()));
    // bad testcase: applicant is not the owner of insurance
    assertFalse(RegistrationValidator.isDriverTheOwnerInInsurance(badFullName, applicantBadTest.getVehicleInsurance()));
  }

  @Test
  public void isInsuranceNotExpired() {
    // good testcase: applicant vehicle insurance is not expired:
    assertTrue(RegistrationValidator.isInsuranceNotExpired(applicantPeter.getVehicleInsurance().getExpiration()));
    // bad testcase: applicant vehicle insurance is expired:
    assertFalse(RegistrationValidator.isInsuranceNotExpired(applicantBadTest.getVehicleInsurance().getExpiration()));
  }

  //--------------Driver’s history--------------
  @Test
  public void isAcceptedByCheckingDriverHistory() {
     assertTrue(RegistrationValidator.isAcceptedByCheckingDriverHistory(applicantPeter.getDriverHistory()));
     assertFalse(RegistrationValidator.isAcceptedByCheckingDriverHistory(applicantBadTest.getDriverHistory()));

     DriverHistory badDriverHistory1 = new DriverHistory(new Date (11, 10, 2018),
        RecklessDriving, ParkingViolation);
     DriverHistory badDriverHistory2 = new DriverHistory(new Date (11, 10, 2018),
        Speeding, ParkingViolation);
     DriverHistory badDriverHistory3 = new DriverHistory(new Date (11, 10, 2018),
        DrivingUnderInfluence, ParkingViolation);
     DriverHistory badDriverHistory4 = new DriverHistory(new Date (11, 10, 2018),
        DrivingWithoutlicense, ParkingViolation);
     assertFalse(RegistrationValidator.isAcceptedByCheckingDriverHistory(badDriverHistory1));
     assertFalse(RegistrationValidator.isAcceptedByCheckingDriverHistory(badDriverHistory2));
     assertFalse(RegistrationValidator.isAcceptedByCheckingDriverHistory(badDriverHistory3));
     assertFalse(RegistrationValidator.isAcceptedByCheckingDriverHistory(badDriverHistory4));
  }

  //-------------- test vehicle’s history--------------
  @Test
  public void isAcceptedByCheckingVehicleHistory() {
    // good testcase 1: peter has a crash but over 6 month ago
    assertTrue(RegistrationValidator.isAcceptedByCheckingVehicleHistory(applicantPeter.getVehicleHistory()));

    // good testcase 2: a good vehicle history with not any crash or violation
    VehicleHistory goodCarHistory = new VehicleHistory(null, peterFullName,
        null, null, null);
    assertTrue(RegistrationValidator.isAcceptedByCheckingVehicleHistory(goodCarHistory));

    // bad testcase 1: has a crash within 6 month
    VehicleHistory badVechileHistory1 = new VehicleHistory(Crash.FenderBender, peterFullName,
        new Date(1,1,2019), null, null);
    assertFalse(RegistrationValidator.isAcceptedByCheckingVehicleHistory(badVechileHistory1));

    // bad testcase 2: has a moving violation within 6 month
    VehicleHistory badVechileHistory2 = new VehicleHistory(null, peterFullName,
        new Date(1,1,2019), Speeding, null);
    assertFalse(RegistrationValidator.isAcceptedByCheckingVehicleHistory(badVechileHistory1));
  }

  //-------------- test main function of applicant is accepted or not
  @Test
  public void isApplicantAccepted() {
    // good testcase: applicant who pass all checkpoints
    assertTrue(RegistrationValidator.isApplicantAccepted(applicantPeter));
    // bad testcase: applicant who didn't pass all checkpoints
    assertFalse(RegistrationValidator.isApplicantAccepted(applicantBadTest));
  }
}