package A2Prob2;

/**
 * Represents a giftcard with money amount
 * and the giftcard receiver's firstname, lastname and account(card) number
 *
 * @author Roy Chen
 * @version 1.0
 */
public class Deposit {
  private MoneyAmount giftAmount;
  private String firstName;
  private String lastName;
  private Integer cardNumber;

  /**
   * Creates a deposit giftcard with its balance amount as a MoneyAmount class
   * and giftcard receiver's information as following:
   * firstname, lastname as Strings and card(account) number as integer
   *
   * @param giftAmount the balance amount in the gift card
   * @param firstName gift card user firstname
   * @param lastName gift card user lastname
   * @param cardNumber gift card user account(card) number
   * @throws IllegalArgumentException for the legal range of giftcard balance
   */
  public Deposit(MoneyAmount giftAmount, String firstName, String lastName,
      Integer cardNumber) throws IllegalArgumentException {
    if (giftAmount.getTotalAmount()<1 || giftAmount.getTotalAmount()>200){
      throw new IllegalArgumentException("Gift card balance should between 1 and 200.");
    } else {
    this.giftAmount = giftAmount;
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.cardNumber = cardNumber;
  }

  /**
   *
   * @return giftcard balance amount
   */
  public MoneyAmount getGiftAmount() {
    return giftAmount;
  }

  /**
   *
   * @return giftcard user's firstname
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @return giftcard user's lastname
   */
  public String getLastName() {
    return lastName;
  }

  /**
   *
   * @return giftcard user's account/card number
   */
  public Integer getCardNumber() {
    return cardNumber;
  }
}
