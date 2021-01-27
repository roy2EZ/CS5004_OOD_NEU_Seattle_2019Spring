package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * represents a interface of products in stock with quantity.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface IStockItem {

  /**
   * check if the quantity of the items in stock is enough for customer to order.
   * @param customerOrderAmount the amount customer want to order
   * @return true if enough, and false otherwise
   */
  Boolean isItemEnoughInStock(Integer customerOrderAmount);

  /**
   * Update the quantity of this item in stock after customer ordered.
   * @param customerOrderAmount the amount customer want to order
   * @return a new StockItem class with updated quantity after customer made the order
   * @throws QuantityInStockNotEnoughException for not enough items in stock for the order
   */
  StockItem reduceQuantityForPurchase(Integer customerOrderAmount)
      throws QuantityInStockNotEnoughException;

}
