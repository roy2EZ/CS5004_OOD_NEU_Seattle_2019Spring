package A2Prob1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DailyEventsTest {

  private DailyEvents dailyEvents1;
  private DailyEvents dailyEvents2;



  @Before
  public void setUp() throws Exception {
    dailyEvents1 = new DailyEvents("Roy",85,true,false);
    dailyEvents2 = new DailyEvents("Peter",37,false,true);
  }


  @Test
  public void creatEvent() throws Exception {
    dailyEvents1.createEvent("Roy",85,true,false);
    assertTrue(dailyEvents1.getIsLunch());
    assertFalse(dailyEvents1.getIsDinner());
    assertEquals(dailyEvents1.getLunchEvent().getClientName(),"Roy");
    assertEquals(dailyEvents1.getLunchEvent().getAttendeeNum(),(Integer)85);
    assertEquals(dailyEvents1.getLunchEvent().getLunchSandwichNum(),(Integer)89);

    dailyEvents2.createEvent("Peter",37,false,true);
    assertTrue(dailyEvents2.getIsDinner());
    assertFalse(dailyEvents2.getIsLunch());
    assertEquals(dailyEvents2.getDinnerEvent().getClientName(),"Peter");
    assertEquals(dailyEvents2.getDinnerEvent().getAttendeeNum(),(Integer)37);
    assertEquals(dailyEvents2.getDinnerEvent().getDinnerNonVegNum(),(Integer)30);
    assertEquals(dailyEvents2.getDinnerEvent().getDinnerVegNum(),(Integer)8);

  }

  @Test
  public void getClientName() {
    assertEquals(dailyEvents1.getClientName(),"Roy");
    assertEquals(dailyEvents2.getClientName(),"Peter");
  }

  @Test
  public void getAttendeeNum() {
    assertEquals(dailyEvents1.getAttendeeNum(),(Integer)85);
    assertEquals(dailyEvents2.getAttendeeNum(),(Integer)37);
  }

  @Test
  public void getIsLunch() {
    assertTrue(dailyEvents1.getIsLunch());
    assertFalse(dailyEvents2.getIsLunch());
  }

  @Test
  public void getIsDinner() {
    assertFalse(dailyEvents1.getIsDinner());
    assertTrue(dailyEvents2.getIsDinner());
  }

  @Test
  public void getIsLunchOccupied() {
    assertTrue(dailyEvents1.getIsLunchOccupied());
  }

  @Test
  public void getIsDinnerOccupied() {
    assertFalse(dailyEvents2.getIsDinnerOccupied());
  }

}