package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Objects;

/**
 * Represents a driver license class including license id, name, address, date of Birth, country,
 * issuance date, expiration date, issue date.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class DriverLicense {
  private String licenseId;
  private Name name;
  private String address;
  private Date dateOfBirth;
  private String country;
  private Date issuance;
  private Date expiration;
  private Date issueDate;

  public DriverLicense(String licenseId, Name name, String address,
      Date dateOfBirth, String country, Date issuance,
      Date expiration, Date issueDate) {
    this.licenseId = licenseId;
    this.name = name;
    this.address = address;
    this.dateOfBirth = dateOfBirth;
    this.country = country;
    this.issuance = issuance;
    this.expiration = expiration;
    this.issueDate = issueDate;
  }

  /**
   * @return - license id
   */
  public String getLicenseId() {
    return licenseId;
  }

  /**
   * @return - return driver's name
   */
  public Name getName() {
    return name;
  }

  /**
   * @return - return driver's address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @return - return driver's date of birth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @return - country of issuance
   */
  public String getCountry() {
    return country;
  }

  /**
   * @return -  issuance date
   */
  public Date getIssuance() {
    return issuance;
  }

  /**
   * @return - expiration date
   */
  public Date getExpiration() {
    return expiration;
  }

  /**
   * @return - issue date
   */
  public Date getIssueDate() {
    return issueDate;
  }

  @Override
  public String toString() {
    return "DriverLicense{"
        + "licenseId='" + licenseId + '\''
        + ", name=" + name
        + ", address='" + address + '\''
        + ", dateOfBirth=" + dateOfBirth
        + ", country='" + country + '\''
        + ", issuance=" + issuance
        + ", expiration=" + expiration
        + ", issueDate='" + issueDate + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    DriverLicense that = (DriverLicense) obj;
    return Objects.equals(licenseId, that.licenseId)
        && Objects.equals(name, that.name)
        && Objects.equals(address, that.address)
        && Objects.equals(dateOfBirth, that.dateOfBirth)
        && Objects.equals(country, that.country)
        && Objects.equals(issuance, that.issuance)
        && Objects.equals(expiration, that.expiration)
        && Objects.equals(issueDate, that.issueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenseId, name, address, dateOfBirth, country, issuance, expiration, issueDate);
  }
}
