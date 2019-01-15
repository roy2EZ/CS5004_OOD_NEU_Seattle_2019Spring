package Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    private Time nowTime;

    @Before
    public void setUp() throws Exception {
        nowTime = new Time(1,26,33);
    }

    @Test
    public void getHour() {
        assertEquals(nowTime.getHour(), (Integer)1);
    }

    @Test
    public void getMin() {
        assertEquals(nowTime.getMin(),(Integer)26);
    }

    @Test
    public void getSec() {
        assertEquals(nowTime.getSec(), (Integer)33);
    }

    @Test
    public void getTotalSec() {
        assertEquals(nowTime.getTotalSec(),(Integer)5193);
    }
}