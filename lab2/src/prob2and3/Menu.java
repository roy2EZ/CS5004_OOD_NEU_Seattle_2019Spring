package prob2and3;

public class Menu {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;

  public Menu(String meals, String desserts, String beverages, String drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  public String getMeals() {
    return meals;
  }

  public void setMeals(String meals) {
    this.meals = meals;
  }

  public String getDesserts() {
    return desserts;
  }

  public void setDesserts(String desserts) {
    this.desserts = desserts;
  }

  public String getBeverages() {
    return beverages;
  }

  public void setBeverages(String beverages) {
    this.beverages = beverages;
  }

  public String getDrinks() {
    return drinks;
  }

  public void setDrinks(String drinks) {
    this.drinks = drinks;
  }
}
