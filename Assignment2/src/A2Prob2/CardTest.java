package A2Prob2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

  private Card royCard;
  private Deposit giftCard;
  private Owner roy;
  private MoneyAmount originalBalance;
  private MoneyAmount giftAmount;

  @Before
  public void setUp() throws Exception {
    roy = new Owner("Roy","Chen","3211 115th Ave, Bellevue WA","chen.rongy@husky.neu.edu");

    originalBalance = new MoneyAmount(13,65);
    giftAmount = new MoneyAmount(79,23);

    royCard = new Card(312369923,roy,originalBalance);
    giftCard = new Deposit(giftAmount,"Roy","Chen",312369923);

  }

  @Test
  public void getCardNum() {
    assertEquals(royCard.getCardNum(),(Integer) 312369923);
  }

  @Test
  public void getOwner() {
    assertEquals(royCard.getOwner().getClass(),Owner.class);
    assertEquals(royCard.getOwner().getFirstName(),"Roy");
    assertEquals(royCard.getOwner().getLastName(),"Chen");
    assertEquals(royCard.getOwner().getAddress(),"3211 115th Ave, Bellevue WA");
    assertEquals(royCard.getOwner().getEmail(),"chen.rongy@husky.neu.edu");
  }

  @Test
  public void getCurrBalance() {
    assertEquals(royCard.getCurrBalance().getClass(),MoneyAmount.class);
    assertEquals(royCard.getCurrBalance().getDollar(),(Integer) 13);
    assertEquals(royCard.getCurrBalance().getCent(),(Integer)65);
    assertEquals(royCard.getCurrBalance().getTotalAmount(),(Double)13.65);
  }

  @Test
  public void depositGift() throws Exception {
    royCard.depositGift(giftCard);
    assertEquals(royCard.getCurrBalance().getDollar(),(Integer)92);
    assertEquals(royCard.getCurrBalance().getCent(),(Integer)88);
    assertEquals(royCard.getCurrBalance().getTotalAmount(),(Double)92.88);
  }
}