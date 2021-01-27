package edu.neu.ccs.cs5004.assignment8.problem1;

import java.util.Objects;

/**
 * Represents a name.
 */
public class Name {

  /**
   * First and last name.
   */
  private String firstName;
  private String lastName;

  /**
   * Creates a name with given first and last name.
   *
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets customer's first name.
   *
   * @return customer's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets customer's last name.
   *
   * @return customer's last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(firstName, name.firstName) &&
        Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return firstName + ' ' + lastName;
  }
}

