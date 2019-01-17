
package prob2and3;

/**
 *  Represents a menu with their details--meals, desserts, beverages and drinks
 *
 * @author roych
 * @version 1.0
 */
public class Menu {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;

  /**
   * Creates a new menu given the menu's meals, desserts, beverages, and drinks
   * @param meals the menu's meals
   * @param desserts the menu's desserts
   * @param beverages the menu's beverages
   * @param drinks the menu's drinks
   */
  public Menu(String meals, String desserts, String beverages, String drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   *
   * @return the meals
   */

  public String getMeals() {
    return meals;
  }

  /**
   *
   * @param meals set the meals
   */
  public void setMeals(String meals) {
    this.meals = meals;
  }

  /**
   *
   * @return the desserts
   */
  public String getDesserts() {
    return desserts;
  }

  /**
   *
   * @param desserts set the desserts
   */
  public void setDesserts(String desserts) {
    this.desserts = desserts;
  }

  /**
   *
   * @return the beverages
   */
  public String getBeverages() {
    return beverages;
  }

  /**
   *
   * @param beverages set the beverages
   */
  public void setBeverages(String beverages) {
    this.beverages = beverages;
  }

  /**
   *
   * @return the drinks
   */
  public String getDrinks() {
    return drinks;
  }

  /**
   *
   * @param drinks set the drinks
   */
  public void setDrinks(String drinks) {
    this.drinks = drinks;
  }
}
