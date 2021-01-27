package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Grocery class representing common behavior among all groceries.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public abstract class Grocery extends Products {

  protected Double weight;

  public Grocery(String manufacturer, String productName, Double price,
      Integer minimumAge, Double weight) {
    super(manufacturer, productName, price, minimumAge);
    this.weight = weight;
  }

  /**
   * Returns weight for all grocery products as a Double.
   * @return - weight for all grocery as a Double
   */
  public Double getWeight() {
    return weight;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Grocery)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    Grocery grocery = (Grocery) obj;
    return Objects.equals(getWeight(), grocery.getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getWeight());
  }

  @Override
  public String toString() {
    return "Grocery{"
        + "weight=" + weight
        + ", manufacturer='" + manufacturer + '\''
        + ", productName='" + productName + '\''
        + ", price=" + price
        + ", minimumAge=" + minimumAge
        + '}';
  }
}
