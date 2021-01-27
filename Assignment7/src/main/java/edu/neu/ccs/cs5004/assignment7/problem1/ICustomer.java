package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.Map;

/**
 * Represents an Customer interface.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public interface ICustomer {
  /**
   * Get the total cost in shopping cart.
   * @return - total cost  as a double
   */
  double getTotalCost();

  /**
   * Prob2 PartB 1: add the product to shopping cart.
   * @param product the product customer want to buy
   * @param customerQuantity how many that product customer want to buy
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  Map addProductToShpCrt(Products product, Integer customerQuantity, Inventory currentStockList);

  /**
   * Prob2 PartB 1.a: if customer not specify the quantity, then default by DEFAULT_QUANTITY = 1
   * @param product the product customer want to buy
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  Map addProductToShpCrt(Products product, Inventory currentStockList);

  /**
   * Pro2 PartB 2: substitute the item in shopping cart.
   * @param newProduct the new product put to the cart
   * @param products the product needs to be substituted
   * @param customerQuantity the quantity of the product in cart
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  Map substituteProduct(Products newProduct, Products products, Integer customerQuantity,
      Inventory currentStockList);

  /**
   * Pro2 PartB 3: processed the order in shopping cart.
   * @param currentInventory the supermarket's current inventory
   * @return - the customer's receipt
   */
  Receipt orderProcessed(Inventory currentInventory);

  /**
   * helper function to determine if the product can be substituted.
   * @param currentInventory the supermarket's current inventory
   * @return - true if the product can be substitute, false otherwise
   */
  boolean canBeSubstitute(Products product, Inventory currentInventory);

}
