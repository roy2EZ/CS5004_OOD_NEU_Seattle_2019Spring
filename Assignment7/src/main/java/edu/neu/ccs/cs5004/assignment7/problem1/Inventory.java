package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents an Inventory with their details -- groceryStockList, householdStockList.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 *
 */
public class Inventory implements IInventory{
  private ArrayList<StockItem> groceryStockList;
  private ArrayList<StockItem> householdStockList;

  public Inventory() {
    groceryStockList = new ArrayList<>();
    householdStockList = new ArrayList<>();
  }

  public ArrayList<StockItem> getGroceryStockList() {
    return groceryStockList;
  }

  public ArrayList<StockItem> getHouseholdStockList() {
    return householdStockList;
  }

  /**
   * Add a new StockItem to the appropriate list.
   * @param stockItem the new StockItem
   */
  @Override
  public void addNewStock(StockItem stockItem) {
    if (stockItem.getProduct() instanceof Grocery) {
      this.groceryStockList.add(stockItem);
    }
    if (stockItem.getProduct() instanceof Household) {
      this.householdStockList.add(stockItem);
    }
  }

  /**
   * Get the total retail value of all items in stock.
   * @return - total retail value as a double
   */
  @Override
  public double getTotalValue() {
    double res = 0;
    double price;
    int quantity;
    int sizeGrocery = groceryStockList.size();
    int sizeHousehold = householdStockList.size();
    for (int i = 0; i < sizeGrocery; i++) {
      price = groceryStockList.get(i).getProduct().price;
      quantity = groceryStockList.get(i).getQuantity();
      res = res + price * quantity;
    }
    for (int j = 0; j < sizeHousehold; j++) {
      price = householdStockList.get(j).getProduct().price;
      quantity = householdStockList.get(j).getQuantity();
      res = res + price * quantity;
    }
    return res;
  }

  /**
   * helper function to get the quantity of a specific product in the stock.
   * @param product the product which need to get quantity in stock
   * @return the quantity of that product in stock
   */
  public Integer getProductQuantityInStock(Products product) {
    Integer res = 0;
    if (product instanceof Grocery) {
      for (int i = 0; i < this.getGroceryStockList().size(); i++) {
        if (product.equals(this.getGroceryStockList().get(i).getProduct())) {
          res = this.getGroceryStockList().get(i).getQuantity();
        }
      }
    } else if (product instanceof Household) {
      for (int j = 0; j < this.getHouseholdStockList().size(); j++) {
        if (product.equals(this.getHouseholdStockList().get(j).getProduct())) {
          res = this.getHouseholdStockList().get(j).getQuantity();
        }
      }
    }
    return res;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) obj;
    return Objects.equals(groceryStockList, inventory.groceryStockList)
        && Objects.equals(householdStockList, inventory.householdStockList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groceryStockList, householdStockList);
  }

  @Override
  public String toString() {
    return "Inventory{"
        + "groceryStockList=" + groceryStockList
        + ", householdStockList=" + householdStockList
        + '}';
  }
}
