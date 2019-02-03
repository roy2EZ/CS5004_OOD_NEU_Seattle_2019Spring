package problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MakeAndModelTest {
  private MakeAndModel testMakeAndModel;

  @Before
  public void setUp() throws Exception {
    testMakeAndModel = new MakeAndModel("testMake", "testModel");
  }

  @Test
  public void getMake() {
    Assert.assertEquals("testMake", testMakeAndModel.getMake());
  }

  @Test
  public void getModel() {
    Assert.assertEquals("testModel", testMakeAndModel.getModel());
  }
}