package problem3;

import static org.junit.Assert.*;

import java.time.Year;
import org.junit.Before;
import org.junit.Test;

public class ConferenceTest {
  private Conference testConference;

  @Before
  public void setUp() throws Exception {
    testConference = new Conference("testTitle", "testAuthor", "testConferenceName",
        "Seattle, WA", Month.JUL, Year.of(2015));
  }

  @Test
  public void getTitle() {
    assertEquals("testTitle", testConference.getTitle());
  }

  @Test
  public void getAuthor() {
    assertEquals("testAuthor", testConference.getAuthor());
  }

  @Test
  public void getConferenceName() {
    assertEquals("testConferenceName", testConference.getConferenceName());
  }

  @Test
  public void getLocation() {
    assertEquals("Seattle, WA", testConference.getLocation());
  }

  @Test
  public void getMonth() {
    assertEquals(Month.JUL, testConference.getMonth());
    assertEquals("JUL", testConference.getMonth().toString());
  }

  @Test
  public void getYear() {
    assertEquals(2015, testConference.getYear().getValue());
  }
}
