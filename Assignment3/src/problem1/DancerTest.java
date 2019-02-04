package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DancerTest {
  private Dancer tester;
  private String[] testerGenre;
  private String[] testerAwards;
  private ArtWork testerArtWorks;
  private String[] testerMovies;
  private String[] testerSeries;
  private String[] testerOtherMedia;

  @Before
  public void setUp() throws Exception {
    testerGenre = new String[] {"Genre1", "Genre2", "Genre3"};
    testerAwards = new String[] {"Awards1", "Awards2", "Awards3", "Awards4"};
    testerMovies = new String[] {"Movie1", "Movie2"};
    testerSeries = new String[] {"TV1", "TV2", "TV3"};
    testerOtherMedia = new String[] {"YouTube", "Netflix"};
    testerArtWorks = new ArtWork(testerMovies, testerSeries, testerOtherMedia);
    tester = new Dancer("testName", 30, "1979 - 1995",
        testerGenre, testerAwards, testerArtWorks);
  }

  @Test
  public void getArtWork() {
    Assert.assertEquals(testerArtWorks, tester.getArtWork());
    Assert.assertArrayEquals(testerMovies, tester.getArtWork().getMovies());
    Assert.assertEquals("TV1", tester.getArtWork().getSeries()[0]);
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
    Dancer invalidAgeTester = new Dancer("testName", 500, "1979 - 1995",
        testerGenre,testerAwards, testerArtWorks);
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