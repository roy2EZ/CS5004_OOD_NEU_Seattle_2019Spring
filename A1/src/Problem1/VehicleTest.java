package Problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle myCar;
    private Owner roy;

    @Before
    public void setUp() throws Exception {
        roy = new Owner("Roy", "Chen", "3123699923");
        myCar = new Vehicle(1234, "BJD1601", roy);
    }

    @Test
    public void getVIN() {
        assertEquals(myCar.getVIN(), 1234);
    }

    @Test
    public void getLicensePlate() {
        assertEquals(myCar.getLicensePlate(), "BJD1601");
    }

    @Test
    public void getOwner() {
        assertEquals(myCar.getOwner(), roy);
    }

    @Test
    public void setVIN() {
        myCar.setVIN(5678);
        assertEquals(myCar.getVIN(), 5678);
    }

    @Test
    public void setLicensePlate() {
        myCar.setLicensePlate("ABC123");
        assertEquals(myCar.getLicensePlate(), "ABC123");
    }
}