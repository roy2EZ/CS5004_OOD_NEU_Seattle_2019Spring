package edu.neu.ccs.cs5004.assignment8.problem2;

/**
 * Represents a vehicle class including make, model, owner, year
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class Vehicle {
  private String makeAndModel;
  private Name owner;
  private int year;

  public Vehicle(String makeAndModel, Name owner, int year) {
    this.makeAndModel = makeAndModel;
    this.owner = owner;
    this.year = year;
  }

  /**
   * @return - vehicle's make and mode
   */
  public String getMakeAndModel() {
    return makeAndModel;
  }

  /**
   * @return - vehicle's owner
   */
  public Name getOwner() {
    return owner;
  }

  /**
   * @return - vehicle's year
   */
  public int getYear() {
    return year;
  }
}