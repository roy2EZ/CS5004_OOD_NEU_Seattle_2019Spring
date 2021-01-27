package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Products class encodes common states and behavior among different products.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public abstract class Products {

  protected static final Integer MOST_CASE_AGE = 0;

  protected String manufacturer;
  protected String productName;
  protected Double price;
  protected Integer minimumAge;

  /**
   * Constructs products with its details -- manufacturer, productName, price and minimumAge.
   * @param manufacturer manufacturer of the products as String
   * @param productName name of the products as String
   * @param price price of the products as Double
   * @param minimumAge minimum age of customer who can buy this products as Integer
   */
  public Products(String manufacturer, String productName, Double price, Integer minimumAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Returns manufacturer as a String.
   * @return - manufacturer as a String
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Returns product name as a String.
   * @return - product name as a String
   */
  public String getProductName() {
    return productName;
  }

  /**
   * Returns price as a Double.
   * @return - price as a Double
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Returns minimum age as a Integer.
   * @return - minimum age as a Integer
   */
  public Integer getMinimumAge() {
    return minimumAge;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Products)) {
      return false;
    }
    Products products = (Products) obj;
    return Objects.equals(manufacturer, products.manufacturer)
        && Objects.equals(productName, products.productName)
        && Objects.equals(price, products.price)
        && Objects.equals(minimumAge, products.minimumAge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manufacturer, productName, price, minimumAge);
  }


}
