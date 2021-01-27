package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverLicenseTest {
  private DriverLicense driverLicense;
  private Name name;
  private Date birthDate;
  private Date issuance;
  private Date expiration;
  private Date issueDate;

  // To test not equal
  private Name name2;
  private Date birthDate2;
  private Date issuance2;
  private Date expiration2;
  private Date issueDate2;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hao", "Xu");
    birthDate = new Date(30, 3, 1995);
    issuance = new Date(10, 8, 2015);
    expiration = new Date(10, 8, 2020);
    issueDate = new Date(10, 8, 2017);

    driverLicense = new DriverLicense("XH**12345", name, "1727 25th ave s", birthDate,
        "US", issuance, expiration, issueDate);

    // To test not equal
    name2 = new Name("Hang", "Xue");
    birthDate2 = new Date(3, 1, 1995);
    issuance2 = new Date(1, 7, 2015);
    expiration2 = new Date(1, 5, 2020);
    issueDate2 = new Date(10, 9, 2017);
  }

  @Test
  public void getLicenseId() {
    assertEquals("XH**12345", driverLicense.getLicenseId());
  }

  @Test
  public void getName() {
    assertEquals(name, driverLicense.getName());
  }

  @Test
  public void getAddress() {
    assertEquals("1727 25th ave s", driverLicense.getAddress());
  }

  @Test
  public void getDateOfBirth() {
    assertEquals(birthDate, driverLicense.getDateOfBirth());
  }

  @Test
  public void getCountry() {
    assertEquals("US", driverLicense.getCountry());
  }

  @Test
  public void getIssuance() {
    assertEquals(issuance, driverLicense.getIssuance());
  }

  @Test
  public void getExpiration() {
    assertEquals(expiration, driverLicense.getExpiration());
  }

  @Test
  public void getIssueDate() {
    assertEquals(issueDate, driverLicense.getIssueDate());
  }

  @Test
  public void testToString() {
    assertEquals("DriverLicense{licenseId='XH**12345', name=Name{firstName='Hao', "
        + "lastName='Xu'}, address='1727 25th ave s', dateOfBirth=Date{day=30, month=3, year=1995},"
        + " country='US', issuance=Date{day=10, month=8, year=2015}, expiration=Date{day=10, "
        + "month=8, year=2020}, issueDate='Date{day=10, month=8, year=2017}}",
        driverLicense.toString());
  }

  @Test
  public void equals() {
    DriverLicense copyDriverLicense = driverLicense;
    DriverLicense sameDriverLicense = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate,"US", issuance,
        expiration, issueDate);
    DriverLicense anotherLicense = copyDriverLicense;

    DriverLicense driverLicense1 = new DriverLicense("different", name,
        "1727 25th ave s", birthDate,"US", issuance,
        expiration, issueDate);

    DriverLicense driverLicense2 = new DriverLicense("XH**12345", name2,
        "1727 25th ave s", birthDate,"US", issuance,
        expiration, issueDate);

    DriverLicense driverLicense3 = new DriverLicense("XH**12345", name,
        "different", birthDate,"US", issuance,
        expiration, issueDate);

    DriverLicense driverLicense4 = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate2,"US", issuance,
        expiration, issueDate);

    DriverLicense driverLicense5 = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate,"different", issuance,
        expiration, issueDate);

    DriverLicense driverLicense6 = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate,"US", issuance2,
        expiration, issueDate);

    DriverLicense driverLicense7 = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate,"US", issuance,
        expiration2, issueDate);

    DriverLicense driverLicense8 = new DriverLicense("XH**12345", name,
        "1727 25th ave s", birthDate,"US", issuance,
        expiration, issueDate2);

    assertTrue(driverLicense.equals(driverLicense));
    assertFalse(driverLicense.equals(issuance));
    assertFalse(driverLicense.equals(null));
    assertTrue(driverLicense.equals(copyDriverLicense));
    assertTrue(driverLicense.equals(sameDriverLicense));
    assertTrue(sameDriverLicense.equals(copyDriverLicense));
    assertTrue(driverLicense.equals(copyDriverLicense));
    assertFalse(driverLicense.equals(driverLicense1));
    assertFalse(driverLicense.equals(driverLicense2));
    assertFalse(driverLicense.equals(driverLicense3));
    assertFalse(driverLicense.equals(driverLicense4));
    assertFalse(driverLicense.equals(driverLicense5));
    assertFalse(driverLicense.equals(driverLicense6));
    assertFalse(driverLicense.equals(driverLicense7));
    assertFalse(driverLicense.equals(driverLicense8));

  }

  @Test
  public void testHashCode() {
    DriverLicense copyDriverLicense = driverLicense;
    assertTrue(driverLicense.hashCode() == copyDriverLicense.hashCode());
  }
}