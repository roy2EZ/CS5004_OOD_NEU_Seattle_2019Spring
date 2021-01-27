package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Objects;

/**
 * Represents a name class including first name and last name;
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class Name {
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return - first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns - last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
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
}
