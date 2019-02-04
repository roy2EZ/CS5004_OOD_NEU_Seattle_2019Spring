package problem3;

import java.time.Year;
import org.junit.Before;
import org.junit.Test;

public class JournalTest {
  private Journal testJournal;



  @Before
  public void setUp() throws Exception {
    testJournal = new Journal("testJournalTitle", "testJournalAuthor", "Science of Lies",
        33, "JUL", Year.of(2001));
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
  public void getJournalName() {
  }

  @Test
  public void getIssueNum() {
  }

  @Test
  public void getMonth() {
  }


}