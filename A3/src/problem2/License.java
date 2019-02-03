package problem2;

/**
 * represents a license plate document with state, license number and expiration date
 */
public class License {
  private String state;
  private String licenseNum;
  private String expiration;

  public License(String state, String licenseNum, String expiration) {
    this.state = state;
    this.licenseNum = licenseNum;
    this.expiration = expiration;
  }

  /**
   * @return state name of the license
   */
  public String getState() {
    return state;
  }

  /**
   * @return license number as a string
   */
  public String getLicenseNum() {
    return licenseNum;
  }

  /**
   * @return expiration month and year as a string
   */
  public String getExpiration() {
    return expiration;
  }
}
