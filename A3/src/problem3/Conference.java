package problem3;

import java.time.Month;
import java.time.Year;

/**
 * represents a conference publication
 */
public class Conference extends AbstractPublication {

  private String conferenceName;
  private String location;
  private Month month;

  /**
   * @param title  the title of the conference publication
   * @param author the author
   * @param conferenceName the name of the conference
   * @param location the location of the conference
   * @param month the month that publication published
   * @param year the year that publication published
   */
  public Conference(String title, String author, String conferenceName,
      String location, Month month, Year year) {
    super(title, author, year);
    this.conferenceName = conferenceName;
    this.location = location;
    this.month = month;
  }

  public String getConferenceName() {
    return conferenceName;
  }

  public String getLocation() {
    return location;
  }

  public Month getMonth() {
    return month;
  }
}
