package A2Prob2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DepositTest {
  private MoneyAmount testGift;
  private Deposit testDeposit;

  @Before
  public void setUp() throws Exception {
    testGift = new MoneyAmount(23,76);
    testDeposit = new Deposit(testGift,"Roy","Chen",312369923);
  }

  @Test
  public void getGiftAmount() {
    assertEquals(testDeposit.getGiftAmount().getClass(),MoneyAmount.class);
    assertEquals(testDeposit.getGiftAmount().getDollar(),(Integer)23);
    assertEquals(testDeposit.getGiftAmount().getCent(),(Integer)76);
    assertEquals(testDeposit.getGiftAmount().getTotalAmount(),(Double)23.76);
  }

  @Test
  public void getFirstName() {
    assertEquals(testDeposit.getFirstName(),"Roy");
  }

  @Test
  public void getLastName() {
    assertEquals(testDeposit.getLastName(),"Chen");
  }

  @Test
  public void getCardNumber() {
    assertEquals(testDeposit.getCardNumber(),(Integer)312369923);
  }
}