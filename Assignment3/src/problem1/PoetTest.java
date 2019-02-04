package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PoetTest {
  private Poet tester;
  private String[] testerGenre;
  private String[] testerAwards;


  @Before
  public void setUp() throws Exception {
    testerGenre = new String[] {"Genre1", "Genre2", "Genre3"};
    testerAwards = new String[] {"Awards1", "Awards2", "Awards3", "Awards4"};
    tester = new Poet("testName", 30, "1979 - 1995",testerGenre, testerAwards);
  }

  @Test
  public void getName() {
    Assert.assertEquals("testName", tester.getName());
  }

  @Test
  public void getAge() {
    Integer EXPECTED_AGE = 30;
    Assert.assertEquals(EXPECTED_AGE, tester.getAge());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAge() {
    Poet invalidAgeTester = new Poet("testName", 500, "1979 - 1995",
        testerGenre,testerAwards);
  }

  @Test
  public void getActive() {
    Assert.assertEquals("1979 - 1995", tester.getActive());
  }

  @Test
  public void getGenre() {
    Assert.assertArrayEquals(testerGenre, tester.getGenre());
    Assert.assertEquals("Genre3", tester.getGenre()[2]);
  }


  @Test
  public void getAwards() {
    Assert.assertArrayEquals(testerAwards, tester.getAwards());
    Assert.assertEquals("Awards2", tester.getAwards()[1]);
  }
}