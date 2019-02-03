package problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MotorcycleTest {
  private Motorcycle testVehicle;
  private MakeAndModel testMakeAndModel;
  private License testLicense;

  @Before
  public void setUp() throws Exception {
    testMakeAndModel = new MakeAndModel("Honda", "CRV");
    testLicense = new License("WA", "BJD1601", "FEB 2019");
    testVehicle = new Motorcycle("testColor", testMakeAndModel,
        testLicense, 50, Direction.EASTBOUND);
  }

  @Test
  public void getColor() {
  }

  @Test
  public void getMakeAndModel() {
  }

  @Test
  public void getLicense() {
  }

  @Test
  public void getVelocity() {
  }

  @Test
  public void getDirection() {
  }

  @Test
  public void accelerate() throws Exception {
    testVehicle.accelerate(20);
    Integer newSpeed = 60;
    Assert.assertEquals(newSpeed, testVehicle.getVelocity());
  }

  @Test(expected = Exception.class)
  public void invalidAccelerate() throws Exception {
    testVehicle.accelerate(40);
  }

  @Test(expected = Exception.class)
  public void invalidVelocity() {
    Motorcycle testVehicle2 = new Motorcycle("testColor", testMakeAndModel,
        testLicense, 1000, Direction.EASTBOUND);
  }
}