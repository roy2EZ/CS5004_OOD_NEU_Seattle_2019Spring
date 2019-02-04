package problem3;

import java.time.Year;

/**
 * represents a journal publication
 */
public class Journal extends AbstractPublication {

  private String journalName;
  private Integer issueNum;
  private String month;

  /**
   * @param title  the title of the conference publication
   * @param author the author
   * @param journalName the name of the conference
   * @param issueNum the location of the conference
   * @param month the month that publication published
   * @param year the year that publication published
   */
  public Journal(String title, String author, String journalName,
      Integer issueNum, String month, Year year) {
    super(title, author, year);
    this.journalName = journalName;
    this.issueNum = issueNum;
    this.month = month;
  }

  public String getJournalName() {
    return journalName;
  }

  public Integer getIssueNum() {
    return issueNum;
  }

  public String getMonth() {
    return month;
  }


}
