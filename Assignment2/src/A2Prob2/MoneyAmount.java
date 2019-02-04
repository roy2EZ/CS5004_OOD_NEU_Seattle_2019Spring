package A2Prob2;

/**
 * Presents a kind of Money amount format, with Integer dollar as the dollar part
 * and a two digits Integer cent as the cent part of the money amount.
 *
 * @author RoyChen
 * @version 1.0
 */

public class MoneyAmount {
  private Integer dollar;
  private Integer cent;
  private Double totalAmount;

  /**
   * Creates a new MoneyAmount with its dollar part and cent part
   * and throw exception if the cent part is not in range of 0 to 99.
   *
   * @param dollar
   * @param cent
   * @throws IllegalArgumentException
   */
  public MoneyAmount(Integer dollar, Integer cent) throws IllegalArgumentException {
    this.dollar = dollar;

    if(cent<0 || cent>99){
      throw new IllegalArgumentException("Cent should between 0 and 99.");
    }else{
      this.cent = cent;
    }
    /**
     * cast dollar and cent part into double and put them together as a normal number
     * of total amount, for easy to do calculation in the other methods and class.
      */
    this.totalAmount = (double)dollar +(double)cent/100;
  }

  /**
   *
   * @return the dollar part
   */
  public Integer getDollar() {
    return dollar;
  }

  /**
   *
   * @return the cent part
   */
  public Integer getCent() {
    return cent;
  }

  /**
   *
   * @return the total amount as a double number
   * with both dollor and cent part
   */
  public Double getTotalAmount() {
    return totalAmount;
  }
}
