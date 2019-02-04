package problem3;

import java.time.Year;

/**
 * represents the technical report publication
 */
public class TechnicalReport extends AbstractPublication {

  private Integer TR_ID;
  private String instruction;

  /**
   * @param title the title of the report
   * @param author the author of the report
   * @param TR_ID an identifier for this technical report, typically a number, e.g., 3425
   * @param instruction the name of the institution publishing the technical report
   * @param year the year that report published
   */
  public TechnicalReport(String title, String author, Integer TR_ID,
      String instruction, Year year) {
    super(title, author, year);
    this.TR_ID = TR_ID;
    this.instruction = instruction;
  }

  public Integer getTR_ID() {
    return TR_ID;
  }

  public String getInstruction() {
    return instruction;
  }

  /**
   * @param journalName the name of the conference
   * @param issueNum the location of the conference
   * @param month the month that publication published
   * @param year the year that publication published
   * @return a new journal publication which was a technical report
   */
  public Journal turnTRtoJournal(String journalName, Integer issueNum, Month month, Year year) {
    return new Journal(this.title, this.author, journalName,
        issueNum, month, year);
  }

}
