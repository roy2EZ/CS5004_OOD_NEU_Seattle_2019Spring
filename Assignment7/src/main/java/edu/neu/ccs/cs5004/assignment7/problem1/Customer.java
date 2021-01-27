package edu.neu.ccs.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an Customer with their details -- name, age, shopping cart.
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class Customer implements ICustomer{
  private String name;
  private int age;
  private Map<Products, Integer> shoppingCart;

  // if customer not specify, default quantity is 1 when customer adding a product into shoppingCart
  public static final Integer DEFAULT_QUANTITY = 1;

  /**
   * Constructs a Customer with name as String and age as Integer.
   * @param name the name of customer
   * @param age the age of customer
   */
  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
    shoppingCart = new HashMap<>();
  }

  /**
   * Returns Customer name as a String.
   * @return - Customer name as a String
   */
  public String getName() {
    return name;
  }

  /**
   * Returns Customer age as a int.
   * @return - Customer age as a int
   */
  public int getAge() {
    return age;
  }


  public Map<Products, Integer> getShoppingCart() {
    return shoppingCart;
  }

  /**
   * Get the total cost in shopping cart.
   * @return - total cost  as a double
   */
  @Override
  public double getTotalCost() {
    double res = 0;
    for (Products product: shoppingCart.keySet()) {
      res = res + product.price * shoppingCart.get(product);
    }
    return res;
  }

  /**
   * Prob2 PartB 1: add the product to shopping cart.
   * @param product the product customer want to buy
   * @param customerQuantity how many that product customer want to buy
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  @Override
  public Map addProductToShpCrt(Products product, Integer customerQuantity,
      Inventory currentStockList) {

    // 1.b: check if customer add more quantity than in stock
    // call getProductQuantityInStock() to get the quantity in stock of that product
    Integer quantityInStock = currentStockList.getProductQuantityInStock(product);
    // call checkQuantityInStock() function to compare quantity and throw error message
    try {
      checkQuantityInStock(product,customerQuantity, quantityInStock);
    } catch (QuantityInStockNotEnoughException e) {
      e.printStackTrace();
    }

    // 1.c: add that product into shopping cart with quantity
    if (customerQuantity <= quantityInStock) {
      // if quantity is legal to be add, update the shopping cart with that <product, quantity> pair
      this.shoppingCart.put(product, customerQuantity);
      return this.getShoppingCart();
    } else {
      // if quantity is larger than in stock, do nothing and just return the current shopping cart
      return this.getShoppingCart();
    }
  }

  /**
   * Prob2 PartB 1.a: if customer not specify the quantity, then default by DEFAULT_QUANTITY = 1
   * @param product the product customer want to buy
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  @Override
  public Map addProductToShpCrt(Products product, Inventory currentStockList) {
    this.shoppingCart = this.addProductToShpCrt(product, DEFAULT_QUANTITY, currentStockList);
    return this.getShoppingCart();
  }

  /**
   * Prob2 PartB 1.b: check if customer add more quantity than the product quantity in stock
   * @param product the product customer want to buy
   * @param customerQuantity how many that product customer want to buy
   * @param quantityInStock how many that product in stock
   * @throws QuantityInStockNotEnoughException if customer quantity is larger than quantity in stock
   */
  private void checkQuantityInStock(Products product, Integer customerQuantity,
      Integer quantityInStock) throws QuantityInStockNotEnoughException {
    // If customer add more items than they are in stock, an error message will be thrown
    if ( customerQuantity > quantityInStock) {
      throw new QuantityInStockNotEnoughException(String.format("Only %d %s left in stock",
          quantityInStock, product.getProductName()));
    }
  }

  /**
   * Pro2 PartB 2: substitute the item in shopping cart.
   * @param newProduct the new product put to the cart
   * @param products the product needs to be substituted
   * @param customerQuantity the quantity of the product in cart
   * @param currentStockList current inventory of all items in stock
   * @return - updated shopping cart as Map
   */
  @Override
  public Map substituteProduct(Products newProduct, Products products, Integer customerQuantity,
      Inventory currentStockList) {
    if (currentStockList.getProductQuantityInStock(newProduct) > 0
        && products.getClass() == newProduct.getClass()
        && newProduct.getPrice() <= products.getPrice()) {
      if (products instanceof Grocery && newProduct instanceof Grocery) {
        if (((Grocery) products).getWeight() <= ((Grocery) newProduct).getWeight()) {
          this.shoppingCart.remove(products);
          this.shoppingCart.put(newProduct, customerQuantity);
        }
      }

      if (products instanceof Household && newProduct instanceof Household) {
        if (((Household) products).getUnits() <= ((Household) newProduct).getUnits()) {
          this.shoppingCart.remove(products);
          this.shoppingCart.put(newProduct, customerQuantity);
        }
      }
    } else {
      this.shoppingCart.remove(products, customerQuantity);
    }
    return this.getShoppingCart();
  }

  /**
   * Pro2 PartB 3: processed the order in shopping cart.
   * @param currentInventory the supermarket's current inventory
   * @return - the customer's receipt
   */
  @Override
  public Receipt orderProcessed(Inventory currentInventory) {
    List<Products> removed = new ArrayList<>();
    List<Products> received = new ArrayList<>();
    List<Products> outOfStock = new ArrayList<>();
    for (Products product: shoppingCart.keySet()) {
      received.add(product);
      if (product.minimumAge > this.age) {
        shoppingCart.remove(product);
        removed.add(product);
      }
      if (currentInventory.getProductQuantityInStock(product) <= 0) {
        if (!canBeSubstitute(product, currentInventory)) {
          outOfStock.add(product);
        }
      }
    }
    double totalPrice = this.getTotalCost();
    shoppingCart = new HashMap<>();
    return new Receipt(totalPrice, received, outOfStock, removed);
  }

  /**
   * helper function to determine if the product can be substituted.
   * @param currentInventory the supermarket's current inventory
   * @return - true if the product can be substitute, false otherwise
   */
  @Override
  public boolean canBeSubstitute(Products product, Inventory currentInventory) {
    if (product instanceof Grocery) {
      for (StockItem stockProduct:  currentInventory.getGroceryStockList()) {
        if (product.getPrice() > stockProduct.getProduct().getPrice()) {
          if (((Grocery)product).getWeight() <= ((Grocery)stockProduct.getProduct()).getWeight()) {
            return true;
          }
        }
      }
      return false;
    } else if (product instanceof Household) {
      for (StockItem stockProduct: currentInventory.getHouseholdStockList()) {
        if (product.getPrice() > stockProduct.getProduct().getPrice()) {
          if (((Household)product).getUnits()
              <= ((Household)stockProduct.getProduct()).getUnits()) {
            return true;
          }
        }
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Customer{"
        + "name='" + name + '\''
        + ", age=" + age
        + ", shoppingCart=" + shoppingCart
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    return age == customer.age
        && Objects.equals(name, customer.name)
        && Objects.equals(shoppingCart, customer.shoppingCart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, shoppingCart);
  }
}
