package A2Prob2;

/**
 * Represent a card account with the card number, owner's information and balance
 * Has a method to deposit a giftcard's money into account current balance
 *
 */
public class Card {
  private Integer cardNum;
  private Owner owner;
  private MoneyAmount currBalance;


  /**
   * creates a new card with card number as 9 digit integer,
   * owner information as Owner class,
   * current balance as a MoneyAccount class
   * @param cardNum
   * @param owner
   * @param currBalance
   */
  public Card(Integer cardNum, Owner owner, MoneyAmount currBalance) {
    /**
     * throw exception if the card number is not 9 digits
     */
    if(cardNum.toString().length()!=9){
      throw new IllegalArgumentException("Card Number should 9 digits.");
    }else{
      this.cardNum = cardNum;
    }

    this.owner = owner;

    /**
     * throw an exception if the dollar part of balance is negative
     */
    if (currBalance.getDollar()<0){
      throw new IllegalArgumentException("Balance is below 0");
    }else{
      this.currBalance = currBalance;
    }
  }

  /**
   *
   * @return card(account) number
   */
  public Integer getCardNum() {
    return cardNum;
  }

  /**
   *
   * @return owner information
   */
  public Owner getOwner() {
    return owner;
  }

  /**
   *
   * @return current balance
   */
  public MoneyAmount getCurrBalance() {
    return currBalance;
  }

  /**
   * a method which can deposit money from a giftcard which is a Deposit object.
   * It will check the giftcard user's information to see if it match the account owner
   * if match, it will add the balance in giftcard into account current balance and update the account
   *
   * @param newGift a Deposit object
   * @return a new Card with updated balance by adding gift card balance to account balance
   * @throws Exception if user's firstname, lastname or card number not matching, will throw exception
   */
  public Card depositGift(Deposit newGift) throws Exception {
    if((newGift.getCardNumber()).equals(cardNum)
        && (this.getOwner().getFirstName().equals(newGift.getFirstName()))
        && (this.getOwner().getLastName().equals((newGift.getLastName())))){
      Double newTotal = newGift.getGiftAmount().getTotalAmount()+currBalance.getTotalAmount();
      Integer newDollar = (int)Math.floor(newTotal);
      Integer newCent = ((int)Math.floor(newTotal*100)) - newDollar*100;
      MoneyAmount updateBalance = new MoneyAmount(newDollar, newCent);
      return new Card(this.cardNum,this.owner,this.currBalance = updateBalance);
    }else{
      throw new Exception("Account info not match.");
    }
    
  }
}
