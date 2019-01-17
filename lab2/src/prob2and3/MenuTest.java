package prob2and3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MenuTest {

  private Menu testMenu;

  @Before
  public void setUp() throws Exception {
    testMenu = new Menu("Burger","Ice cream","Coke","Mojito");
  }

  @Test
  public void getMeals() {
    assertEquals(testMenu.getMeals(),"Burger");
  }

  @Test
  public void setMeals() {
    testMenu.setMeals("Noodle");
    assertEquals(testMenu.getMeals(),"Noodle");
  }

  @Test
  public void getDesserts() {
    assertEquals(testMenu.getDesserts(),"Ice cream");
  }

  @Test
  public void setDesserts() {
    testMenu.setDesserts("Pudding");
    assertEquals(testMenu.getDesserts(),"Pudding");
  }

  @Test
  public void getBeverages() {
    assertEquals(testMenu.getBeverages(),"Coke");
  }

  @Test
  public void setBeverages() {
    testMenu.setBeverages("Sprite");
    assertEquals(testMenu.getBeverages(),"Sprite");
  }

  @Test
  public void getDrinks() {
    assertEquals(testMenu.getDrinks(),"Mojito");
  }

  @Test
  public void setDrinks() {
    testMenu.setDrinks("Whiskey");
    assertEquals(testMenu.getDrinks(),"Whiskey");
  }
}