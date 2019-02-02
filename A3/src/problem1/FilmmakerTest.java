package problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilmmakerTest {
  private Filmmaker kubrick;
  private String[] kubrickGenre;
  private String[] kubrickAwards;
  private ArtWork kubrickArtWork;
  private String[] kubrickMovies;
  private String[] kubrickSeries;
  private String[] kubrickOtherMedia;


  @Before
  public void setUp() throws Exception {
    kubrickGenre = new String[] {"Film director", "Screenwriter", "Producer"};
    kubrickAwards = new String[] {"Oscars", "British Academy Film Awards", "Golden Globe Awards",
        "Hugo Awards"};
    kubrickMovies = new String[] {"2001: A Space Odyssey", "The Shining", "Full Metal Jacket",
        "Eyes Wide Shut"};
    kubrickSeries = new String[] {"Up Late with Alec Baldwin", "American Masters"};
    kubrickOtherMedia = new String[] {"Film 101"};
    kubrickArtWork = new ArtWork(kubrickMovies, kubrickSeries, kubrickOtherMedia);
    kubrick = new Filmmaker("Stanley Kubrick", 72, "1950s - 1990s",
        kubrickGenre, kubrickAwards, kubrickArtWork);
  }

  @Test
  public void getArtWork() {
    Assert.assertEquals(kubrickArtWork, kubrick.getArtWork());
    Assert.assertArrayEquals(kubrickMovies, kubrick.getArtWork().getMovies());
    Assert.assertArrayEquals(kubrickSeries, kubrick.getArtWork().getSeries());
    Assert.assertArrayEquals(kubrickOtherMedia, kubrick.getArtWork().getOtherMedia());
    Assert.assertEquals("2001: A Space Odyssey", kubrick.getArtWork().getMovies()[0]);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Stanley Kubrick", kubrick.getName());
  }

  @Test
  public void getAge() {
    Integer EXPECTED_AGE = 72;
    Assert.assertEquals(EXPECTED_AGE, kubrick.getAge());
  }

  @Test
  public void getActive() {
    Assert.assertEquals("1950s - 1990s", kubrick.getActive());
  }

  @Test
  public void getGenre() {
    Assert.assertArrayEquals(kubrickGenre, kubrick.getGenre());
  }

  @Test
  public void getAwards() {
    Assert.assertArrayEquals(kubrickAwards, kubrick.getAwards());
    Assert.assertEquals("Oscars", kubrick.getAwards()[0]);
  }
}