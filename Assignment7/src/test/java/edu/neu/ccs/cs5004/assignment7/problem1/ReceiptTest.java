package edu.neu.ccs.cs5004.assignment7.problem1;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
  private Receipt receipt;
  private List<Products> received;
  private List<Products> outOfStock;
  private List<Products> removed;

  Beer tsingtaoBeer;
  Beer bud;
  Cheese cheddarCheese;
  Shampoo headAndShouldersShampoo;
  Shampoo pantene;


  @Before
  public void setUp() throws Exception {
    tsingtaoBeer = new Beer("Tsingtao Brewery Co.,Ltd.", "Tsingtao Beer",
        13.99,21,72.0);
    bud = new Beer("Anheuser-Busch", "Budweiser", 12.99,
        21,84.0);
    cheddarCheese = new Cheese("Cabot Creamery Cooperative", "Cabot Extra "
        + "Sharp Cheddar", 6.99, 0, 8.0);
    headAndShouldersShampoo = new Shampoo("P&G", "Head & Shoulders",
        14.73, Products.MOST_CASE_AGE, 2);
    pantene = new Shampoo("P&G", "Pantene", 12.99,
        Products.MOST_CASE_AGE, 3);
    received = new ArrayList<>();
    outOfStock = new ArrayList<>();
    removed = new ArrayList<>();
    received.add(cheddarCheese);
    received.add(headAndShouldersShampoo);
    outOfStock.add(pantene);
    removed.add(tsingtaoBeer);
    removed.add(bud);
    receipt = new Receipt(1000.00, received, outOfStock, removed);
  }

  @Test
  public void getTotalPriceTest() {
    assertEquals(1000.00, receipt.getTotalPrice(), 0.1);
  }

  @Test
  public void getReceivedTest() {
    assertEquals(received, receipt.getReceived());
  }

  @Test
  public void getOutOfStock() {
    assertEquals(outOfStock, receipt.getOutOfStock());
  }

  @Test
  public void getRemoved() {
    assertEquals(removed, receipt.getRemoved());
  }

  @Test
  public void toStringTest() {
    assertEquals("Receipt{totalPrice=1000.0, received=[Grocery{weight=8.0, "
            + "manufacturer='Cabot Creamery Cooperative', productName='Cabot Extra Sharp Cheddar', "
            + "price=6.99, minimumAge=0}, Household{units=2, manufacturer='P&G', "
            + "productName='Head & Shoulders', price=14.73, minimumAge=0}], "
            + "outOfStock=[Household{units=3, manufacturer='P&G', productName='Pantene', "
            + "price=12.99, minimumAge=0}], removed=[Grocery{weight=72.0, "
            + "manufacturer='Tsingtao Brewery Co.,Ltd.', productName='Tsingtao Beer', "
            + "price=13.99, minimumAge=21}, Grocery{weight=84.0, manufacturer='Anheuser-Busch', "
            + "productName='Budweiser', price=12.99, minimumAge=21}]}",receipt.toString());
  }

  @Test
  public void equals() {
    Receipt another = receipt;
    assertTrue(another.equals(receipt));
  }
}