package A2Prob1;


/**
*
* Represents a lunch event which extends Event class,
* with the number of sandwich should be prepared
*
* @author Roy Chen
* @version 1.0
*
*/
public class LunchEvent extends Event {
  private Integer lunchSandwichNum;
  private static final Double LUNCH_PCT = 1.05;

  /**
   * creates a new lunch event
   * @param clientName
   * @param attendeeNum
   * @param isLunch
   * @param isDinner
   */
  public LunchEvent(String clientName, Integer attendeeNum, Boolean isLunch, Boolean isDinner) {
    super(clientName, attendeeNum, isLunch, isDinner);
    lunchSandwichNum = (int)Math.round(attendeeNum*LUNCH_PCT);
  }

  /**
   *
   * @return needed sandwich amounts
   */
  public Integer getLunchSandwichNum() {
    return lunchSandwichNum;
  }
}
