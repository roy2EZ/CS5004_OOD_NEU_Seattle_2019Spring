package Problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {

    private Amount testAmount;

    @Before
    public void setUp() throws Exception {
        testAmount = new Amount(1214,87);
    }

    @Test
    public void getDollar() {
        assertEquals(testAmount.getDollar(),(Integer)1214);
    }

    @Test
    public void getCent() {
        assertEquals(testAmount.getCent(),(Integer)87);
    }

    @Test
    public void setDollar() {
        testAmount.setDollar(1031);
        assertEquals(testAmount.getDollar(),(Integer)1031);
    }

    @Test
    public void setCent() {
        testAmount.setCent(89);
        assertEquals(testAmount.getCent(),(Integer)89);
    }


}