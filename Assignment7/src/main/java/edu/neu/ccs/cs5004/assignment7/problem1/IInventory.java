package edu.neu.ccs.cs5004.assignment7.problem1;

/**
 * Represents an Inventory interface.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface IInventory {
  /**
   * Add a new StockItem to the appropriate list.
   * @param stockItem the new StockItem
   */
  void addNewStock(StockItem stockItem);

  /**
   * Get the total retail value of all items in stock.
   * @return - total retail value as a double
   */
  double getTotalValue();

  /**
   * helper function to get the quantity of a specific product in the stock.
   * @param product the product which need to get quantity in stock
   * @return the quantity of that product in stock
   */
  Integer getProductQuantityInStock(Products product);

}
