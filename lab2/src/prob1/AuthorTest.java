package prob1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

  private Author testRoy;

  public AuthorTest() {
  }

  @Before
  public void setUp() throws Exception {

    testRoy = new Author("Roy","Chen",
        "chen.rongy@husky.neu.edu",
        "3211 115th Ave NE, Bellevue WA 98004");

  }

  @Test
  public void getFirstname() {
    Assert.assertEquals("Roy", testRoy.getFirstname());

  }

  @Test
  public void getLastname() {
    Assert.assertEquals("Chen",testRoy.getLastname());
  }

  @Test
  public void getFullname() {
    Assert.assertEquals("Roy Chen",testRoy.getFullname());
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("chen.rongy@husky.neu.edu", testRoy.getEmail());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("3211 115th Ave NE, Bellevue WA 98004",testRoy.getAddress());
  }
}