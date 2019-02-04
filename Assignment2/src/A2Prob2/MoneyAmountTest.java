package A2Prob2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyAmountTest {

  private MoneyAmount testMoney;
  @Before
  public void setUp() throws Exception {
    testMoney = new MoneyAmount(24,97);
  }

  @Test
  public void getDollar() {
    assertEquals(testMoney.getDollar(),(Integer)24);
  }

  @Test
  public void getCent() {
    assertEquals(testMoney.getCent(),(Integer)97);
  }

  @Test
  public void getTotalAmount() {
    assertEquals(testMoney.getTotalAmount(),(Double)24.97);
  }


}