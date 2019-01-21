package A2Prob1;

/**
 *
 * Represents a Dinner event which extends Event class,
 * with the number of non-vegan entrees and vegan entrees
 *
 * @author Roy Chen
 * @version 1.0
 *
 */


public class DinnerEvent extends Event {
  private Integer dinnerNonVegNum;
  private Integer dinnerVegNum;
  private static final Double DINNER_NON_VEG_PCT = 0.8;
  private static final Double DINNER_VEG_PCT = 0.2;

  /**
   * Creates a new dinner event
   * @param clientName
   * @param attendeeNum
   * @param isLunch
   * @param isDinner
   */
  public DinnerEvent(String clientName, Integer attendeeNum, Boolean isLunch, Boolean isDinner) {
    super(clientName, attendeeNum, isLunch, isDinner);
    dinnerNonVegNum = (int)Math.ceil(attendeeNum*DINNER_NON_VEG_PCT);
    dinnerVegNum = (int)Math.ceil(attendeeNum*DINNER_VEG_PCT);
  }

  /**
   *
   * @return number of non-vegan entrees
   */
  public Integer getDinnerNonVegNum() {
    return dinnerNonVegNum;
  }

  /**
   *
   * @return number of vegan entrees
   */
  public Integer getDinnerVegNum() {
    return dinnerVegNum;
  }
}
