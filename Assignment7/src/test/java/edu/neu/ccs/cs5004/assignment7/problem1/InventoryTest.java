package edu.neu.ccs.cs5004.assignment7.problem1;

import static edu.neu.ccs.cs5004.assignment7.problem1.Products.MOST_CASE_AGE;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
  // the stock inventory
  Inventory currStockInventory;

  // products
  Beer tsingtaoBeer;
  Cheese cheddarCheese;
  Shampoo headAndShouldersShampoo;

  // products in stock
  StockItem tsingtaoBeerInStock;
  StockItem cheddarCheeseInStock;
  StockItem headAndShouldersShampooInStock;

  @Before
  public void setUp() throws Exception {
    // create the stock inventory
    currStockInventory = new Inventory();
    // create products
    tsingtaoBeer = new Beer("Tsingtao Brewery Co.,Ltd.", "Tsingtao Beer", 13.99,21,72.0);
    cheddarCheese = new Cheese("Cabot Creamery Cooperative", "Cabot Extra Sharp Cheddar", 6.99, MOST_CASE_AGE, 8.0);
    headAndShouldersShampoo = new Shampoo("P&G", "Head & Shoulders", 14.73, MOST_CASE_AGE, 2);
    // put those products in stock with quantity
    tsingtaoBeerInStock = new StockItem(tsingtaoBeer, 100);
    cheddarCheeseInStock = new StockItem(cheddarCheese, 140);
    headAndShouldersShampooInStock = new StockItem(headAndShouldersShampoo, 500);
  }

  @Test
  public void addNewStock() {
    // add a grocery products: bearToAdd
    currStockInventory.addNewStock(tsingtaoBeerInStock);
    // check if the StockItem tsingtaoBeerInStock successfully added into the inventory
    assertEquals(tsingtaoBeerInStock, currStockInventory.getGroceryStockList().get(0));
    // add another grocery: cheddarCheeseInStock
    currStockInventory.addNewStock(cheddarCheeseInStock);
    assertEquals(cheddarCheeseInStock, currStockInventory.getGroceryStockList().get(1));

    // add a household products: headAndShouldersShampooInStock, it should go to household list
    currStockInventory.addNewStock(headAndShouldersShampooInStock);
    assertEquals(headAndShouldersShampooInStock, currStockInventory.getHouseholdStockList().get(0));

  }

  @Test
  public void getTotalValue() {
    // add a grocery products: bearToAdd
    currStockInventory.addNewStock(tsingtaoBeerInStock);
    // total value should be all beer's total price: 100*13.99 = 1399
    assertEquals(1399.0, currStockInventory.getTotalValue(),0.01);

    // add another grocery: cheddarCheeseInStock
    currStockInventory.addNewStock(cheddarCheeseInStock);
    // total value should be beer and cheese total price: 1399 + 978.6 = 2377.6
    assertEquals(2377.6, currStockInventory.getTotalValue(),0.01);

    // add a household products: headAndShouldersShampooInStock
    currStockInventory.addNewStock(headAndShouldersShampooInStock);
    // total value should be beer + cheese + shampoo = 2377.6 + 7365 = 9742.6
    assertEquals(9742.6, currStockInventory.getTotalValue(),0.01);

  }

  @Test
  public void getProductQuantityInStock() {
    currStockInventory.addNewStock(tsingtaoBeerInStock);
    currStockInventory.addNewStock(cheddarCheeseInStock);
    currStockInventory.addNewStock(headAndShouldersShampooInStock);

    assertEquals(tsingtaoBeerInStock.getQuantity(), currStockInventory.getProductQuantityInStock(tsingtaoBeer));
    assertEquals(cheddarCheeseInStock.getQuantity(), currStockInventory.getProductQuantityInStock(cheddarCheese));
    assertEquals(headAndShouldersShampooInStock.getQuantity(), currStockInventory.getProductQuantityInStock(headAndShouldersShampoo));

  }

  @Test
  public void equalsTest(){
    currStockInventory.addNewStock(tsingtaoBeerInStock);
    currStockInventory.addNewStock(cheddarCheeseInStock);
    Inventory newInventory = currStockInventory;
    assertEquals(true, currStockInventory.equals(newInventory));

  }

  @Test
  public void toStringTest(){
    currStockInventory.addNewStock(tsingtaoBeerInStock);
    currStockInventory.addNewStock(cheddarCheeseInStock);
    assertEquals("Inventory{groceryStockList=[StockItem{product=Grocery{weight=72.0, "
        + "manufacturer='Tsingtao Brewery Co.,Ltd.', productName='Tsingtao Beer', price=13.99, "
        + "minimumAge=21}, quantity=100}, StockItem{product=Grocery{weight=8.0, manufacturer='Cabot "
        + "Creamery Cooperative', productName='Cabot Extra Sharp Cheddar', price=6.99, minimumAge=0}, "
        + "quantity=140}], householdStockList=[]}", currStockInventory.toString());
  }

}