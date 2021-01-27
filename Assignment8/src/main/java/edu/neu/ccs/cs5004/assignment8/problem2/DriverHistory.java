package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Objects;

/**
 * Represents a driver history class including date, MovingViolation, nonMovingViolation
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class DriverHistory {
  private Date date;
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;

  public DriverHistory(Date date,
      MovingViolation movingViolation,
      NonMovingViolation nonMovingViolation) {
    this.date = date;
    this.movingViolation = movingViolation;
    this.nonMovingViolation = nonMovingViolation;
  }

  /**
   * @return - date of violation
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
   * @return - nonMoving Violation
   */
  public NonMovingViolation getNonMovingViolation() {
    return nonMovingViolation;
  }

  @Override
  public String toString() {
    return "DriverHistory{" +
        "date =" + date.getYear() + "/" + date.getMonth() + "/" + date.getDay()
        + ", MovingViolation = " + movingViolation +
        ", nonMovingViolation = " + nonMovingViolation +
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
    DriverHistory that = (DriverHistory) obj;
    return Objects.equals(date, that.date) &&
        movingViolation == that.movingViolation &&
        nonMovingViolation == that.nonMovingViolation;
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, movingViolation, nonMovingViolation);
  }
}
