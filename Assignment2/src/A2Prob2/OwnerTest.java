package A2Prob2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OwnerTest {

  private Owner roy;

  @Before
  public void setUp() throws Exception {
    roy = new Owner("Roy","Chen","3211 115th Ave, Bellevue WA","chen.rongy@husky.neu.edu");
  }

  @Test
  public void getFirstName() {
    assertEquals(roy.getFirstName(),"Roy");
  }

  @Test
  public void getLastName() {
    assertEquals(roy.getLastName(),"Chen");
  }

  @Test
  public void getAddress() {
    assertEquals(roy.getAddress(),"3211 115th Ave, Bellevue WA");
  }

  @Test
  public void getEmail() {
    assertEquals(roy.getEmail(),"chen.rongy@husky.neu.edu");
  }
}