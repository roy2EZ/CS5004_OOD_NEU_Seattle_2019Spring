package edu.neu.ccs.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
  // the stock inventory
  Inventory currentStockInventory;

  // products
  Beer tsingtaoBeer;
  Beer bud;
  Cheese cheddarCheese;
  Shampoo headAndShouldersShampoo;
  Shampoo pantene;

  // products in stock
  StockItem tsingtaoBeerInStock;
  StockItem budBeerInStock;
  StockItem cheddarCheeseInStock;
  StockItem headAndShouldersShampooInStock;
  StockItem panteneShampooInStock;

  // the customer
  Customer bob;

  @Before
  public void setUp() throws Exception {
    // create the stock inventory
    currentStockInventory = new Inventory();

    // create products
    tsingtaoBeer = new Beer("Tsingtao Brewery Co.,Ltd.", "Tsingtao Beer", 13.99,21,72.0);
    bud = new Beer("Anheuser-Busch", "Budweiser", 12.99,21,84.0);
    cheddarCheese = new Cheese("Cabot Creamery Cooperative", "Cabot Extra Sharp Cheddar", 6.99, 0, 8.0);
    headAndShouldersShampoo = new Shampoo("P&G", "Head & Shoulders", 14.73, Products.MOST_CASE_AGE, 2);
    pantene = new Shampoo("P&G", "Pantene", 12.99, Products.MOST_CASE_AGE, 3);

    // put those products in stock with quantity
    tsingtaoBeerInStock = new StockItem(tsingtaoBeer, 100);
    budBeerInStock = new StockItem(bud, 100);
    cheddarCheeseInStock = new StockItem(cheddarCheese, 140);
    headAndShouldersShampooInStock = new StockItem(headAndShouldersShampoo, 500);
    panteneShampooInStock = new StockItem(pantene, 500);

    // add products into inventory
    currentStockInventory.addNewStock(tsingtaoBeerInStock);
    currentStockInventory.addNewStock(budBeerInStock);
    currentStockInventory.addNewStock(cheddarCheeseInStock);
    currentStockInventory.addNewStock(headAndShouldersShampooInStock);
    currentStockInventory.addNewStock(panteneShampooInStock);

    // create the customers
    bob = new Customer("Bob", 29);
  }

  @Test
  public void getName() {
    assertEquals("Bob", bob.getName());
  }

  @Test
  public void getAge() {
    assertEquals(29, bob.getAge());
  }

  // test Prob2 PartB 1.a:
  // if customer not specify quantity, then default quantity is one
  @Test
  public void addProductToShpCrt1() {
    // test good quantity
    bob.addProductToShpCrt(tsingtaoBeer, currentStockInventory);
    assertEquals(1,bob.getShoppingCart().get(tsingtaoBeer).intValue());

  }

  @Test
  public void addProductToShpCrt2() {
    // test Good shopping quantity
    bob.addProductToShpCrt(tsingtaoBeer, 10, currentStockInventory);
    assertEquals(10,bob.getShoppingCart().get(tsingtaoBeer).intValue());

    // add another different product
    bob.addProductToShpCrt(cheddarCheese, 20,currentStockInventory);
    assertEquals(20,bob.getShoppingCart().get(cheddarCheese).intValue());

    // test to update quantity of a product already in the shopping cart
    bob.addProductToShpCrt(tsingtaoBeer, 30, currentStockInventory);
    assertEquals(30,bob.getShoppingCart().get(tsingtaoBeer).intValue());

  }

  @Test
  public void addProductToShpCrt3() {
    // test Bad customer quantity which is lager than the product quantity in stock
    // should throw QuantityInStockNotEnoughException
    bob.addProductToShpCrt(tsingtaoBeer, 150, currentStockInventory);

    // then add Good quantity of that product into shopping cart, should still successfully added
    bob.addProductToShpCrt(tsingtaoBeer, 10, currentStockInventory);
    assertEquals(10,bob.getShoppingCart().get(tsingtaoBeer).intValue());

  }

  @Test
  public void getTotalCost() {
    // add some products into the shopping cart
    bob.addProductToShpCrt(tsingtaoBeer, 10, currentStockInventory);
    bob.addProductToShpCrt(cheddarCheese, 20,currentStockInventory);
    bob.addProductToShpCrt(headAndShouldersShampoo, 5,currentStockInventory);

    // the total cost should be 10*13.99 + 20*6.99 + 5*14.73 = 353.35
    assertEquals(353.35, bob.getTotalCost(), 0.02);
  }

  // Prob 2 Part B 2: substitute

  @Test
  public void substituteProduct() {
    bob.addProductToShpCrt(tsingtaoBeer, 10, currentStockInventory);
    assertEquals(10, bob.getShoppingCart().get(tsingtaoBeer).intValue());
    // Products can only be substituted with the same specific type of product
    bob.substituteProduct(bud,tsingtaoBeer,10,currentStockInventory);
    assertEquals(10, bob.getShoppingCart().get(bud).intValue());

    bob.addProductToShpCrt(headAndShouldersShampoo, 10, currentStockInventory);
    assertEquals(10, bob.getShoppingCart().get(headAndShouldersShampoo).intValue());
    // Products can only be substituted with the same specific type of product
    bob.substituteProduct(pantene,headAndShouldersShampoo,10,currentStockInventory);
    assertEquals(10, bob.getShoppingCart().get(pantene).intValue());

  }

  @Test
  public void canBeSubstitutedTestOne(){
    Products budLight = new Beer("BudLight.,Ltd.", "BudLight Beer", 18.00,21,50.78);
    StockItem budLightInStock = new StockItem(budLight, 0);
    currentStockInventory.addNewStock(budLightInStock);
    assertEquals(true, bob.canBeSubstitute(budLight, currentStockInventory));
  }

  @Test
  public void canBeSubstitutedTestTwo(){
    Products blueMoon = new Beer("blueMoon.,Ltd.", "blueMoon Beer", 10.00,21,16.00);
    StockItem blueMoonInStock = new StockItem(blueMoon, 0);
    currentStockInventory.addNewStock(blueMoonInStock);
    assertEquals(false, bob.canBeSubstitute(blueMoon, currentStockInventory));
  }

  @Test
  public void canBeSubstitutedTestThree(){
    Products olay = new Shampoo("PMG,Ltd.","olay shampoo", 15.00,21,3);
    StockItem olayInStock = new StockItem(olay, 0);
    currentStockInventory.addNewStock(olayInStock);
    assertEquals(true, bob.canBeSubstitute(olay, currentStockInventory));
  }

  @Test
  public void canBeSubstitutedTestFour(){
    Products olay = new Shampoo("PMG,Ltd.","olay shampoo", 25.78,21,5);
    StockItem olayInStock = new StockItem(olay, 0);
    currentStockInventory.addNewStock(olayInStock);
    assertEquals(false, bob.canBeSubstitute(olay, currentStockInventory));
  }

  @Test
  public void orderProcessed(){
    bob.addProductToShpCrt(tsingtaoBeer, 10, currentStockInventory);
    bob.addProductToShpCrt(pantene, currentStockInventory);
    bob.addProductToShpCrt(cheddarCheese, currentStockInventory);
    List<Products> received = new ArrayList<>();
    Receipt receipt = bob.orderProcessed(currentStockInventory);
    received.add(pantene);
    received.add(cheddarCheese);
    received.add(tsingtaoBeer);
    assertEquals(new Receipt(159.88, received, new ArrayList<>(), new ArrayList<>()), receipt);
  }

  @Test
  public void equalsTest(){
    Customer newCustomer = bob;
    assertTrue(bob.equals(newCustomer));
    Customer sameName = new Customer("bob", 35);
    Customer sameAge = new Customer("peter", 29);
    assertFalse(bob.equals(sameName));
    assertFalse(bob.equals(sameAge));
  }

  @Test
  public void toStringTest(){
    assertEquals("Customer{name='Bob', age=29, shoppingCart={}}", bob.toString());
  }
}