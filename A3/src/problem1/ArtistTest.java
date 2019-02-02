package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArtistTest {

  private Artist roy;
  private String[] royGenre;
  private String[] royAwards;

  @Before
  public void setUp() throws Exception {
    royGenre = new String[] {"Tenor", "Accordionist"};
    royAwards = new String[] {"Best singer BJTU student singing competition"};
    roy = new Artist("Roy Chen", 31, "1995 - current", royGenre, royAwards);

  }

  @Test
  public void getName() {
    Assert.assertEquals("Roy Chen", roy.getName());
  }

  @Test
  public void GetAge() {
    Integer EXPECTED_AGE = 31;
    Assert.assertEquals(EXPECTED_AGE, roy.getAge());
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidAgeInitialization() {
     new Artist("Roy Chen", 500, "1995 - current", royGenre, royAwards);
  }

  @Test
  public void getActive() {
    Assert.assertEquals("1995 - current", roy.getActive());

  }

  @Test
  public void getGenre() {
    Assert.assertArrayEquals(royGenre, roy.getGenre());
    Assert.assertEquals("Tenor", roy.getGenre()[0]);
  }

  @Test
  public void getAwards() {
    Assert.assertArrayEquals(royAwards, roy.getAwards());
    Assert.assertEquals(royAwards[0], roy.getAwards()[0]);
  }
}