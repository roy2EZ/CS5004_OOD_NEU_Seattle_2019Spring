package A2Prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

  private Event testEvent;

  @Before
  public void setUp() throws Exception {
    testEvent = new Event("Roy",37,true,false);
  }

  @Test
  public void getClientName() {
    assertEquals(testEvent.getClientName(),"Roy");
  }


  @Test
  public void getAttendeeNum() {
    assertEquals(testEvent.getAttendeeNum(),(Integer)37);
  }

  @Test
  public void getIsLunch() {
    assertTrue(testEvent.getIsLunch());
  }

  @Test
  public void getIsDinner() {
    assertFalse(testEvent.getIsDinner());
  }
}