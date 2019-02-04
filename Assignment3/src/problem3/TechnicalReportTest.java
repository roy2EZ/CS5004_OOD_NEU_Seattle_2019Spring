package problem3;

import static org.junit.Assert.*;

import java.time.Year;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TechnicalReportTest {
  private Journal testJournal;
  private TechnicalReport testTR;


  @Before
  public void setUp() throws Exception {
    testJournal = new Journal("testJournalTitle", "testJournalAuthor", "Science of Lies",
        33, Month.JUL, Year.of(2001));
    testTR = new TechnicalReport("The art of lies", "John Steward",
        1224, "Institute of Human Behavior", Year.of(1999));
  }


  @Test
  public void turnTRtoJournal() {
    Journal newJournal = testTR.turnTRtoJournal(testJournal.getJournalName(), testJournal.getIssueNum(),
        testJournal.getMonth(), testJournal.getYear());
    Assert.assertEquals("The art of lies", newJournal.getTitle());
    Assert.assertEquals("John Steward", newJournal.getAuthor());
    Assert.assertEquals("Science of Lies", newJournal.getJournalName());
    Integer EXPECTED_ISSUE = 33;
    Assert.assertEquals(EXPECTED_ISSUE, newJournal.getIssueNum());
    Assert.assertEquals("JUL", newJournal.getMonth().toString());
    Assert.assertEquals(2001, newJournal.getYear().getValue());
  }

  @Test
  public void getTitle() {
    assertEquals("The art of lies", testTR.getTitle());
  }

  @Test
  public void getAuthor() {
    assertEquals("John Steward", testTR.getAuthor());
  }

  @Test
  public void getTR_ID() {
    Integer EXPECTED_TR_ID = 1224;
    assertEquals(EXPECTED_TR_ID, testTR.getTR_ID());
  }

  @Test
  public void getInstruction() {
    assertEquals("Institute of Human Behavior", testTR.getInstruction());
  }

  @Test
  public void getYear() {
    assertEquals(2001, testJournal.getYear().getValue());
  }

}