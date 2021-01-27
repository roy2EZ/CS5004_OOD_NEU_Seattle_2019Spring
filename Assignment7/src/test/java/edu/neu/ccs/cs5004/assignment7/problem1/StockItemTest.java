package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {
  Beer tsingtaoBeer;
  Salmon testSalmon;
  PaperTowels testPaperTowler;
  StockItem testStockItem;
  StockItem testSalmonInStock;
  StockItem testPaperInStock;

  Integer goodOrderAmount;
  Integer badOrderAmount;

  @Before
  public void setUp() throws Exception {
    tsingtaoBeer = new Beer("Tsingtao Brewery Co.,Ltd.", "Tsingtao Beer", 13.99,21,72.0);
    testStockItem = new StockItem(tsingtaoBeer, 45);
    goodOrderAmount = 35;
    badOrderAmount = 55;

    testSalmon = new Salmon("salmon company", "test salmon", 12.99,Products.MOST_CASE_AGE,72.0);
    testSalmonInStock = new StockItem(testSalmon, 45);

    testPaperTowler = new PaperTowels("paper towels company", "test paper towels", 11.99,Products.MOST_CASE_AGE,4);
    testPaperInStock = new StockItem(testPaperTowler, 45);

  }

  @Test
  public void getProduct() {
    assertEquals(tsingtaoBeer, testStockItem.getProduct());
    assertEquals(testSalmon, testSalmonInStock.getProduct());
    assertEquals(testPaperTowler, testPaperInStock.getProduct());
  }

  @Test
  public void getQuantity() {
    assertEquals(new Integer(45), testStockItem.getQuantity());
    assertEquals(new Integer(45), testSalmonInStock.getQuantity());
    assertEquals(new Integer(45), testPaperInStock.getQuantity());
  }

  @Test
  public void isItemEnoughInStock() {
    assertTrue(testStockItem.isItemEnoughInStock(goodOrderAmount));
    assertFalse(testStockItem.isItemEnoughInStock(badOrderAmount));
  }

  @Test
  public void reduceQuantityForPurchase() throws QuantityInStockNotEnoughException {
    // create new item with updated quantity after calling reduceQuantityForPurchase() function
    StockItem updatedQuantityStockItem = testStockItem.reduceQuantityForPurchase(goodOrderAmount);
    // product is still the same
    assertEquals(tsingtaoBeer,updatedQuantityStockItem.getProduct());
    // quantity updated after purchase
    assertEquals(new Integer(10), updatedQuantityStockItem.getQuantity());
  }

  // test bad result that customer want to purchase more quantity of the items in stock
  @Test(expected = QuantityInStockNotEnoughException.class )
  public void reduceWithBadOrderAmount() throws QuantityInStockNotEnoughException {
    // use bad order amount to make order, should throw expected exception
    StockItem updatedQuantityStockItem = testStockItem.reduceQuantityForPurchase(badOrderAmount);
    // check if the item is not changed with fail purchase
    assertEquals(tsingtaoBeer, testStockItem.getProduct());
    assertEquals(new Integer(45), testStockItem.getQuantity());
  }
}