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
        33, "Jul", Year.of(2001));
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
    Assert.assertEquals("Jul", newJournal.getMonth());
    Assert.assertEquals(Year.of(2001), newJournal.getYear());

  }


  @Test
  public void getTitle() {
  }

  @Test
  public void getAuthor() {
  }

  @Test
  public void getYear() {
  }

  @Test
  public void getTR_ID() {
  }

  @Test
  public void getInstruction() {
  }


}