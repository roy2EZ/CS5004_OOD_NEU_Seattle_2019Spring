package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * represents a class to show the quantities of products in stock.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class StockItem implements IStockItem{
  private Products product;
  private Integer quantity;

  /**
   * constructs a stock item.
   * @param product the product
   * @param quantity how many this product in stock
   */
  public StockItem(Products product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Products getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  /**
   * check if the quantity of the items in stock is enough for customer to order.
   * @param customerOrderAmount the amount customer want to order
   * @return true if enough, and false otherwise
   */
  @Override
  public Boolean isItemEnoughInStock(Integer customerOrderAmount) {
    if (this.getQuantity() >= customerOrderAmount) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Update the quantity of this item in stock after customer ordered.
   * @param customerOrderAmount the amount customer want to order
   * @return a new StockItem class with updated quantity after customer made the order
   * @throws QuantityInStockNotEnoughException for not enough items in stock for the order
   */
  @Override
  public StockItem reduceQuantityForPurchase(Integer customerOrderAmount)
      throws QuantityInStockNotEnoughException {
    if (this.isItemEnoughInStock(customerOrderAmount)) {
      StockItem newStockItem = new StockItem(this.product, this.quantity - customerOrderAmount);
      return newStockItem;
    } else {
      throw new QuantityInStockNotEnoughException("Not enough item in stock for this order amount");
    }
  }

  @Override
  public String toString() {
    return "StockItem{"
        + "product=" + product
        + ", quantity=" + quantity
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof StockItem)) {
      return false;
    }
    StockItem stockItem = (StockItem) obj;
    return Objects.equals(product, stockItem.product)
        && Objects.equals(quantity, stockItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }
}
