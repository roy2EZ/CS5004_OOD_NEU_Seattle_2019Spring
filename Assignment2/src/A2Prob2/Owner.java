package A2Prob2;

/**
 * Represents an owner with their -- first name, last name.
 * physical address and email address.
 *
 * @author Roy Chen
 * @version 1.0
 */

public class Owner {

  private String firstName;
  private String lastName;
  private String address;
  private String email;

  /**
   * Creates a new owner with fisrtName and lastName, address and email as String
   * @param firstName
   * @param lastName
   * @param address
   * @param email
   */
  public Owner(String firstName, String lastName, String address, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
  }

  /**
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   *
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   *
   * @return email address
   */
  public String getEmail() {
    return email;
  }
}
