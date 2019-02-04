package problem3;

import java.time.Year;

/**
 * represents the technical report publication
 */
public class TechnicalReport extends AbstractPublication {

  private Integer TR_ID;
  private Integer instruction;

  /**
   * @param title the title of the report
   * @param author the author of the report
   * @param TR_ID an identifier for this technical report, typically a number, e.g., 3425
   * @param instruction the name of the institution publishing the technical report
   * @param year the year that report published
   */
  public TechnicalReport(String title, String author, Integer TR_ID,
      Integer instruction, Year year) {
    super(title, author, year);
    this.TR_ID = TR_ID;
    this.instruction = instruction;
  }

  public Integer getTR_ID() {
    return TR_ID;
  }

  public Integer getInstruction() {
    return instruction;
  }
}
