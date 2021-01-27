package edu.neu.ccs.cs5004.assignment8.problem2;


import java.util.Objects;

/**
 * Represents a vehicle history class including name, crash, date, moving Violation and nonMovingViolation
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class VehicleHistory {
  private Crash crash;
  private Name name;
  private Date date;
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;

  public VehicleHistory(Crash crash, Name name, Date date,
      MovingViolation movingViolation,
      NonMovingViolation nonMovingViolation) {
    this.crash = crash;
    this.name = name;
    this.date = date;
    this.movingViolation = movingViolation;
    this.nonMovingViolation = nonMovingViolation;
  }

  /**
   * @return - vehicle's crash
   */
  public Crash getCrash() {
    return crash;
  }

  /**
   * @return -  name of the offending driver
   */
  public Name getName() {
    return name;
  }

  /**
   * @return - violation's date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @return - moving Violation
   */
  public MovingViolation getMovingViolation() {
    return movingViolation;
  }

  /**
   * @return - NonMovingViolation
   */
  public NonMovingViolation getNonMovingViolation() {
    return nonMovingViolation;
  }

  @Override
  public String toString() {
    return "VehicleHistory{" +
        "crash=" + crash +
        ", name=" + name +
        ", date=" + date +
        ", MovingViolation=" + movingViolation +
        ", nonMovingViolation=" + nonMovingViolation +
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
    VehicleHistory that = (VehicleHistory) obj;
    return crash == that.crash &&
        Objects.equals(name, that.name) &&
        Objects.equals(date, that.date) &&
        movingViolation == that.movingViolation &&
        nonMovingViolation == that.nonMovingViolation;
  }

  @Override
  public int hashCode() {
    return Objects.hash(crash, name, date, movingViolation, nonMovingViolation);
  }
}