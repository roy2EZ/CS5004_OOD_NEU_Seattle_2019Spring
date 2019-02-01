package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArtWorkTest {

  private String[] testMovies;
  private String[] testSeries;
  private String[] testMedia;

  @Before
  public void setUp() throws Exception {
    testMovies = new String[] {"A Clockwork Orange", "The Shining", "Eyes Wide Shut"};
    testSeries = new String[] {"Shameless", "Breaking Bad", "Game of Thrones", "Modern Family"};
    testMedia = new String[] {"Black Mirror", "Mind Field"};
  }

  @Test
  public void getMovies() {
    String[] expectedMovies = {"A Clockwork Orange", "The Shining", "Eyes Wide Shut"};
    Assert.assertArrayEquals(expectedMovies, testMovies);
    Assert.assertEquals("The Shining", testMovies[1]);
  }

  @Test
  public void getSeries() {
    String[]  expectedSeries = {"Shameless", "Breaking Bad", "Game of Thrones", "Modern Family"};
    Assert.assertArrayEquals(expectedSeries, testSeries);
    Assert.assertEquals("Game of Thrones", testSeries[2]);
  }

  @Test
  public void getOtherMedia() {
    String[] expectedMedia = {"Black Mirror", "Mind Field"};
    Assert.assertArrayEquals(expectedMedia, testMedia);
    Assert.assertEquals("Black Mirror", testMedia[0]);
  }
}