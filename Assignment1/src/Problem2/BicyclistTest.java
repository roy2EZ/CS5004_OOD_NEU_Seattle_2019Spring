package Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicyclistTest {

    private Bicyclist armstrong;
    private Time startTime;
    private Time endTime;

    @Before
    public void setUp() throws Exception {
        startTime = new Time(8, 45, 12);
        endTime = new Time(15, 3, 48);
        armstrong = new Bicyclist("Lance Armstrong", "Motorola", startTime, endTime);
    }

    @Test
    public void getName() {
        assertEquals(armstrong.getName(),"Lance Armstrong");
    }

    @Test
    public void getTeam() {
        assertEquals(armstrong.getTeam(),"Motorola");
    }

    @Test
    public void getStartTime() {
        assertEquals(armstrong.getStartTime().getHour(), (Integer)8);
        assertEquals(armstrong.getStartTime().getMin(), (Integer)45);
        assertEquals(armstrong.getStartTime().getSec(), (Integer)12);
    }

    @Test
    public void getEndTime() {
        assertEquals(armstrong.getEndTime().getHour(), (Integer)15);
        assertEquals(armstrong.getEndTime().getMin(), (Integer)3);
        assertEquals(armstrong.getEndTime().getSec(), (Integer)48);

    }

    @Test
    public void getDuration() {
        assertEquals(armstrong.getDuration().getHour(),(Integer)6 );
        assertEquals(armstrong.getDuration().getMin(),(Integer)18);
        assertEquals(armstrong.getDuration().getSec(),(Integer)36);
    }
}