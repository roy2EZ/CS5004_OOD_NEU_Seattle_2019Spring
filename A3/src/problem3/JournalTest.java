package problem3;

import java.time.Year;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JournalTest {
  private Journal testJournal;

  @Before
  public void setUp() throws Exception {
    testJournal = new Journal("testJournalTitle", "testJournalAuthor", "Science of Lies",
        33, Month.JUL, Year.of(2001));
  }

  @Test
  public void getTitle() {
    Assert.assertEquals("testJournalTitle", testJournal.getTitle());
  }

  @Test
  public void getAuthor() {
    Assert.assertEquals("testJournalAuthor", testJournal.getAuthor());
  }

  @Test
  public void getJournalName() {
    Assert.assertEquals("Science of Lies", testJournal.getJournalName());
  }

  @Test
  public void getIssueNum() {
    Integer EXPECTED_ISSUE = 33;
    Assert.assertEquals(EXPECTED_ISSUE, testJournal.getIssueNum());
  }

  @Test
  public void getMonth() {
    Assert.assertEquals("JUL", testJournal.getMonth().toString());
  }

  @Test
  public void getYear() {
    Assert.assertEquals(2001, testJournal.getYear().getValue());
  }
}