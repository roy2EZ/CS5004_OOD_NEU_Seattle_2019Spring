package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Household class representing common behavior of all household products.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public abstract class Household extends Products {

  protected Integer units;

  public Household(String manufacturer, String productName, Double price,
      Integer minimumAge, Integer units) {
    super(manufacturer, productName, price, minimumAge);
    this.units = units;
  }

  /**
   * Returns individual units for all household products as an Integer.
   * @return individual units for all household products as an Integer
   */
  public Integer getUnits() {
    return units;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Household)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    Household household = (Household) obj;
    return Objects.equals(getUnits(), household.getUnits());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getUnits());
  }

  @Override
  public String toString() {
    return "Household{"
        + "units=" + units
        + ", manufacturer='" + manufacturer + '\''
        + ", productName='" + productName + '\''
        + ", price=" + price
        + ", minimumAge=" + minimumAge
        + '}';
  }
}
