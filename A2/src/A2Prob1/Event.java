package A2Prob1;

/**
 * Represents an event for lunch or dinner with their details--
 * client name, attendee number, if the event is lunch or dinner
 *
 * @author RoyChen
 * @version 1.0
 */

public class Event {

  private String clientName;
  private Integer attendeeNum;
  private Boolean isLunch;
  private Boolean isDinner;

  /**
   * Creates a new event given the client's name as string, attendee number as int,
   * isLunch and isDinner as Boolean
   *
   * @param clientName the name of the client
   * @param attendeeNum attendee amount number
   * @param isLunch if the event is lunch, true it is lunch, false for not.
   * @param isDinner if the event is dinner, true for it is dinner, false for not.
   */

  public Event(String clientName, Integer attendeeNum, Boolean isLunch, Boolean isDinner) {
    this.clientName = clientName;
    this.attendeeNum = attendeeNum;
    this.isLunch = isLunch;
    this.isDinner = isDinner;
  }

  /**
   *
   * @return the client's name
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
   * @return if the event is dinner
   */
  public Boolean getIsDinner() {
    return isDinner;
  }
}
