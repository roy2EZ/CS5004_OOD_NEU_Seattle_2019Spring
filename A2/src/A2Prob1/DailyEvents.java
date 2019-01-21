package A2Prob1;

/**
 * Represent a daily events order on a specific day, which may create lunch or dinner event for client
 *
 * @author Roy Chen
 *
 * @version  1.0
 */
public class DailyEvents {
  private String clientName;
  private Integer attendeeNum;
  private Boolean isLunch;
  private Boolean isDinner;
  private LunchEvent lunchEvent;
  private DinnerEvent dinnerEvent;

  private static Boolean isLunchOccupied = false;
  private static Boolean isDinnerOccupied = false;

  private static final Integer MIN_LUNCH_ATTENDEE_NUM = 15;
  private static final Integer MAX_LUNCH_ATTENDEE_NUM = 90;
  private static final Integer MIN_DINNER_ATTENDEE_NUM = 10;
  private static final Integer MAX_DINNER_ATTENDEE_NUM = 50;

  /**
   * create a new daily events order
   * @param clientName
   * @param attendeeNum
   * @param isLunch
   * @param isDinner
   */
  public DailyEvents(String clientName, Integer attendeeNum, Boolean isLunch,
      Boolean isDinner) {
    this.clientName = clientName;
    this.attendeeNum = attendeeNum;
    this.isLunch = isLunch;
    this.isDinner = isDinner;

  }

  /**
   * Create event for specific lunch for dinner event
   * @param clientName
   * @param attendeeNum
   * @param isLunch
   * @param isDinner
   * @throws Exception
   */
  public void createEvent(String clientName, Integer attendeeNum, Boolean isLunch, Boolean isDinner)
      throws Exception {
    DailyEvents newDailyEvents = new DailyEvents(clientName,attendeeNum,isLunch,isDinner);

    if (isLunch){
      this.lunchEvent = newDailyEvents.createLunch(clientName, attendeeNum);
    }
    else if(isDinner){
      this.dinnerEvent = newDailyEvents.createDinner(clientName, attendeeNum);
    }

  }

  /**
   * Method to create lunch event for createEvent
   * @param clientName
   * @param attendeeNum
   * @return
   * @throws Exception
   */
  private LunchEvent createLunch(String clientName,int attendeeNum) throws Exception {
    if (isLunchOccupied == true) {
      throw new Exception("Lunch is already occupied");
    }

    else if((attendeeNum<MIN_LUNCH_ATTENDEE_NUM)||(attendeeNum>MAX_LUNCH_ATTENDEE_NUM)){
      throw new IllegalArgumentException("Lunch attendee number is between 15 and 90.");
    }
    else {

      LunchEvent lunchEvent = new LunchEvent(clientName,attendeeNum,isLunch,isDinner);
      isLunchOccupied = true;

      return lunchEvent;
    }
  }

  /**
   * method to create dinner event
   * @param clientName
   * @param attendeeNum
   * @return
   * @throws Exception
   */
  private DinnerEvent createDinner(String clientName, int attendeeNum) throws Exception {
    if(isDinnerOccupied == true){
      throw new Exception("Dinner is already occupied");
    }
    else if((attendeeNum<MIN_DINNER_ATTENDEE_NUM)||(attendeeNum>MAX_DINNER_ATTENDEE_NUM)){
      throw new IllegalArgumentException("Dinner attendee number is between 10 and 50.");
    }
    else {
      DinnerEvent dinnerEvent = new DinnerEvent(clientName,attendeeNum,isLunch,isDinner);
      isDinnerOccupied = true;
      return dinnerEvent;
    }
  }

  /**
   *
   * @return client name
   */
  public String getClientName() {
    return clientName;
  }

  /**
   *
   * @return attendee number
   */
  public Integer getAttendeeNum() {
    return attendeeNum;
  }

  /**
   *
   * @return if the event is lunch
   */
  public Boolean getIsLunch() {
    return isLunch;
  }

  /**
   *
   * @return if the event is for dinner
   */
  public Boolean getIsDinner() {
    return isDinner;
  }

  /**
   *
   * @return if today's lunch event is already occupied
   */
  public static Boolean getIsLunchOccupied() {
    return isLunchOccupied;
  }

  /**
   *
   * @return if today's dinner event is already occupied
   */
  public static Boolean getIsDinnerOccupied() {
    return isDinnerOccupied;
  }

  /**
   *
   * @return the lunch event class which is created
   */
  public LunchEvent getLunchEvent() {
    return lunchEvent;
  }

  /**
   *
   * @return the dinner event class which is created
   */
  public DinnerEvent getDinnerEvent() {
    return dinnerEvent;
  }
}
