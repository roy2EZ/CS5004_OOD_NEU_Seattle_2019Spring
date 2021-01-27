package edu.neu.ccs.cs5004.assignment8.problem2;
import java.util.List;
import java.util.Objects;

/**
 * Represents a vehicle insurance class including name, other drivers, expiration date
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class VehicleInsurance {
  private Name owner;
  private List<Name> otherDrivers;
  private Date expiration;

  public VehicleInsurance(Name owner, List<Name> otherDrivers,
      Date expiration) {
    this.owner = owner;
    this.otherDrivers = otherDrivers;
    this.expiration = expiration;
  }

  /**
   * @return - insurance's official owner
   */
  public Name getOwner() {
    return owner;
  }

  /**
   * @return -  other people covered by insurance as drivers
   */
  public List<Name> getOtherDrivers() {
    return otherDrivers;
  }

  /**
   * @return - insurance's official expiration
   */
  public Date getExpiration() {
    return expiration;
  }

  @Override
  public String toString() {
    return "VehicleInsurance{"
        + "owner name: " + owner.getFirstName() + " " + owner.getLastName()
        + ", " + otherDrivers.size() + " " + "otherDrivers"
        + ", expiration date: " + expiration.getYear()+ "/" +expiration.getMonth() + "/"
        + expiration.getDay() + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    VehicleInsurance that = (VehicleInsurance) obj;
    return Objects.equals(owner, that.owner)
        && Objects.equals(otherDrivers, that.otherDrivers)
        && Objects.equals(expiration, that.expiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, otherDrivers, expiration);
  }
}
