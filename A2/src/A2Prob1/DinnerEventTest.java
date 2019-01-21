package A2Prob1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinnerEventTest {

  private DinnerEvent testDinner;

  @Before
  public void setUp() throws Exception {
    testDinner = new DinnerEvent("Roy",29,false,true);
  }

  @Test
  public void getClientName() {
    assertEquals(testDinner.getClientName(),"Roy");

  }

  @Test
  public void getAttendeeNum() {
    assertEquals(testDinner.getAttendeeNum(),(Integer)29);
  }

  @Test
  public void getIsLunch() {
    assertFalse(testDinner.getIsLunch());
  }

  @Test
  public void getIsDinner() {
    assertTrue(testDinner.getIsDinner());
  }

  @Test
  public void getDinnerNonVegNum() {
    assertEquals(testDinner.getDinnerNonVegNum(),(Integer)24);
  }

  @Test
  public void getDinnerVegNum() {
    assertEquals(testDinner.getDinnerVegNum(),(Integer)6);
  }
}