package Problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {

    private Owner roy;

    @Before
    public void setUp() throws Exception {
        roy = new Owner("Roy", "Chen", "3123699923");
    }

    @Test
    public void getFirstName() {
        assertEquals(roy.getFirstName(), "Roy");
    }

    @Test
    public void getLastName() {
        assertEquals(roy.getLastName(), "Chen");
    }

    @Test
    public void getPhoneNum() {
        assertEquals(roy.getPhoneNum(), "3123699923");
    }
}