package prob2and3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {

  private Menu testMenu;
  private Restaurant roys;


  @Before
  public void setUp() throws Exception {
    testMenu = new Menu("Burger","Ice cream","Coke","Mojito");
    roys = new Restaurant("Roy's Waikiki","226 Lewers St, Honolulu, HI 96815",true, testMenu);

  }

  @Test
  public void getName() {
    assertEquals(roys.getName(),"Roy's Waikiki");
  }

  @Test
  public void setName() {
    roys.setName("ROY WAIKIKI");
    assertEquals(roys.getName(),"ROY WAIKIKI");
  }

  @Test
  public void getAddress() {
    assertEquals(roys.getAddress(),"226 Lewers St, Honolulu, HI 96815");
  }

  @Test
  public void setAddress() {
    roys.setAddress("2199 Kalia Rd, Honolulu HI 96815");
    assertEquals(roys.getAddress(),"2199 Kalia Rd, Honolulu HI 96815");
  }

  @Test
  public void getOpen() {
    assertTrue(roys.getOpen());
  }

  @Test
  public void setOpen() {
    roys.setOpen(false);
    assertFalse(roys.getOpen());
  }


  @Test
  public void getMenu() {
    assertEquals(roys.getMenu(),testMenu);
    assertEquals(roys.getMenu().getMeals(),"Burger");
    assertEquals(roys.getMenu().getDesserts(),"Ice cream");
    assertEquals(roys.getMenu().getBeverages(),"Coke");
    assertEquals(roys.getMenu().getDrinks(),"Mojito");
  }
}