package problem2;

import static problem2.Direction.EASTBOUND;
import static problem2.Direction.NORTHBOUND;
import static problem2.Direction.WESTBOUND;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TruckTest {
  private Truck testVehicle;
  private MakeAndModel testMakeAndModel;
  private License testLicense;

  @Before
  public void setUp() throws Exception {
    testMakeAndModel = new MakeAndModel("testMake", "testModel");
    testLicense = new License("WA", "BJD1601", "FEB 2019");
    testVehicle = new Truck("testColor", testMakeAndModel,
        testLicense, 50, EASTBOUND);
  }
  // getters test --------------------------------------------------------------------------
  @Test
  public void getColor() {
    Assert.assertEquals("testColor", testVehicle.color);
  }

  @Test
  public void getMakeAndModel() {
    Assert.assertEquals( testMakeAndModel, testVehicle.getMakeAndModel());
    Assert.assertEquals("testMake", testVehicle.getMakeAndModel().getMake());
    Assert.assertEquals("testModel", testVehicle.getMakeAndModel().getModel());
  }

  @Test
  public void getLicense() {
    Assert.assertEquals(testLicense, testVehicle.getLicense());
  }

  @Test
  public void getVelocity() {
    Integer EXPECTED_V = 50;
    Assert.assertEquals(EXPECTED_V, testVehicle.getVelocity());
  }

  @Test
  public void getDirection() {
    Assert.assertEquals(EASTBOUND, testVehicle.getDirection());
  }

  // test accelerate() testcase --------------------------------------------------------------
  @Test
  public void accelerate() throws Exception {
    testVehicle.accelerate(20);
    Integer newSpeed = 60;
    Assert.assertEquals(newSpeed, testVehicle.getVelocity());
  }

  @Test(expected = Exception.class)
  public void invalidAccelerate() throws Exception {
    testVehicle.accelerate(90);
  }

  @Test(expected = Exception.class)
  public void invalidAccFactor() throws Exception {
    testVehicle.accelerate(-5);
  }


  // decelerate() related testcase ------------------------------------------------------------
  @Test
  public void decelerate() throws Exception {
    testVehicle.decelerate(20);
    Integer newSpeed = 40;
    Assert.assertEquals(newSpeed, testVehicle.getVelocity());
  }

  @Test(expected = Exception.class)
  public void invalidDecelerate() throws Exception {
    testVehicle.decelerate(40);
  }

  @Test(expected = Exception.class)
  public void invalidDecFactor() throws Exception {
    testVehicle.decelerate(10000);
  }

  // velocity range test ----------------------------------------------------------------------
  @Test(expected = Exception.class)
  public void invalidVelocity() {
    Truck testVehicle2 = new Truck("testColor", testMakeAndModel,
        testLicense, 1000, EASTBOUND);
  }

  // directionChange() related test -----------------------------------------------------------
  @Test
  public void directionChange() throws Exception {
    testVehicle.directionChange(WESTBOUND);
    Assert.assertEquals(WESTBOUND, testVehicle.getDirection());
    testVehicle.directionChange(EASTBOUND);
    Assert.assertEquals(EASTBOUND, testVehicle.getDirection());
  }

  @Test(expected = Exception.class)
  public void invalidDirectionChange() throws Exception {
    testVehicle.directionChange(NORTHBOUND);
  }
}