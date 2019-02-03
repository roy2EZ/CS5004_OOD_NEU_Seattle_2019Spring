package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LicenseTest {
  private License testLicense;

  @Before
  public void setUp() throws Exception {
    testLicense = new License("WA", "BJD1601", "FEB 2019");

  }

  @Test
  public void getState() {
    assertEquals("WA", testLicense.getState());
  }

  @Test
  public void getLicenseNum() {
    assertEquals("BJD1601", testLicense.getLicenseNum());
  }

  @Test
  public void getExpiration() {
    assertEquals("FEB 2019", testLicense.getExpiration());
  }
}