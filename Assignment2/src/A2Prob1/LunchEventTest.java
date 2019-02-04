package A2Prob1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LunchEventTest {

  private LunchEvent testLunch;

  @Before
  public void setUp() throws Exception {
    testLunch = new LunchEvent("Roy",39,true,false);
  }

  @Test
  public void getClientName() {
    Assert.assertEquals(testLunch.getClientName(),"Roy");
  }

  @Test
  public void getAttendeeNum() {
    Assert.assertEquals(testLunch.getAttendeeNum(),(Integer)39);
  }

  @Test
  public void getIsLunch() {
    Assert.assertTrue(testLunch.getIsLunch());
  }

  @Test
  public void getIsDinner() {
    Assert.assertFalse(testLunch.getIsDinner());
  }

  @Test
  public void getLunchSandwichNum() {
    Assert.assertEquals(testLunch.getLunchSandwichNum(),(Integer)41);
  }
}