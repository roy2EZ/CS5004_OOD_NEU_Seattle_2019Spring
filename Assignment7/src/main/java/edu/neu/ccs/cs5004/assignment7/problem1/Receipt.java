package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.List;
import java.util.Objects;

/**
 * Represents an Receipt with their details. Including:
 * totalPrice, list of products the customer received,
 * A list of any products that were out of stock and could not be substituted,
 * A list of any products that were removed
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class Receipt {
  private double totalPrice;
  private List<Products> received;
  private List<Products> outOfStock;
  private List<Products> removed;

  /**
   * Constructs a Receipt with its details
   * @param totalPrice total price to pay
   * @param received the list of products the customer received when the order was processed.
   * @param outOfStock A list of any products that were out of stock and could not be substituted.
   * @param removed A list of any products removed from the order because minimum age requirements.
   */
  public Receipt(double totalPrice,
      List<Products> received,
      List<Products> outOfStock,
      List<Products> removed) {
    this.totalPrice = totalPrice;
    this.received = received;
    this.outOfStock = outOfStock;
    this.removed = removed;
  }

  /**
   * Get the total price of all items in in the receipt.
   * @return - total price as a double
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * Get the list of products the customer received.
   * @return - received as a List
   */
  public List<Products> getReceived() {
    return received;
  }

  /**
   * Get the list of any products that were out of stock and could not be substituted.
   * @return - outOfStock as List
   */
  public List<Products> getOutOfStock() {
    return outOfStock;
  }

  /**
   * Get the list of any products that were removed.
   * @return - removed as a list
   */
  public List<Products> getRemoved() {
    return removed;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Receipt receipt = (Receipt) obj;
    return Double.compare(receipt.totalPrice, totalPrice) == 0
        && Objects.equals(received, receipt.received)
        && Objects.equals(outOfStock, receipt.outOfStock)
        && Objects.equals(removed, receipt.removed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPrice, received, outOfStock, removed);
  }

  @Override
  public String toString() {
    return "Receipt{"
        + "totalPrice=" + totalPrice
        + ", received=" + received
        + ", outOfStock=" + outOfStock
        + ", removed=" + removed
        + '}';
  }
}