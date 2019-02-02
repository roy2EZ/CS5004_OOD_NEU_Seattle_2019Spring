package problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
  private Actor scarJo;
  private String[] scarJoAwards;
  private ArtWork scarJoArtWork;
  private String[] scarJoMovies;
  private String[] scarJoSeries;
  private String[] scarJoMedia;

  @Before
  public void setUp() throws Exception {
    scarJoAwards = new String[] {"British Academy Film Awards for Best actress 2003",
        "Toronto Film Critics Association Award for Best Supporting Actress 2001",
        "Boston Society of Film Critics Award for Best Actress 2003",
        "MTV Movie Award for Best Fight 2013"};
    scarJoMovies = new String[] {"Captain America: Civil War", "Avengers: Age of Ultron", "Lucy"};
    scarJoSeries = new String[] {"HitRecord on TV", "Entourage"};
    scarJoMedia = new String[] {"Cat on a Hot Tin Roof", "A View from the Bridge"};
    scarJoArtWork = new ArtWork(scarJoMovies, scarJoSeries, scarJoMedia);
    scarJo = new Actor("Scarlett Johansson", 34, "1996 - current", new String[]{"Actress", "Singer"}, scarJoAwards, scarJoArtWork);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Scarlett Johansson", scarJo.getName());
  }

  @Test
  public void getAge() {
    Integer EXPECTED_AGE = 34;
    Assert.assertEquals(EXPECTED_AGE, scarJo.getAge());
  }

  @Test
  public void getActive() {
    Assert.assertEquals("1996 - current", scarJo.getActive());
  }

  @Test
  public void getGenre() {
    String[] EXPECTED_GENRE = new String[] {"Actress", "Singer"};
    Assert.assertArrayEquals(EXPECTED_GENRE, scarJo.getGenre());
    Assert.assertEquals("Actress", scarJo.getGenre()[0]);
    Assert.assertEquals("Singer", scarJo.getGenre()[1]);


  }

  @Test
  public void getAwards() {
    Assert.assertArrayEquals(scarJoAwards, scarJo.getAwards());
    Assert.assertEquals("Toronto Film Critics Association Award for Best Supporting Actress 2001", scarJo.getAwards()[1]);
    for (int i = 0; i < scarJoAwards.length; i++) {
      Assert.assertEquals(scarJoAwards[i], scarJo.getAwards()[i]);
    }

  }

  @Test
  public void getActorArtWork() {
    Assert.assertEquals(scarJoArtWork, scarJo.getActorArtWork());
    Assert.assertArrayEquals(scarJoMovies, scarJo.getActorArtWork().getMovies());
    Assert.assertEquals("Lucy", scarJo.getActorArtWork().getMovies()[2]);
    Assert.assertArrayEquals(scarJoSeries, scarJo.getActorArtWork().getSeries());
    Assert.assertEquals("Entourage", scarJo.getActorArtWork().getSeries()[1]);
    Assert.assertArrayEquals(scarJoMedia, scarJo.getActorArtWork().getOtherMedia());
    Assert.assertEquals("Cat on a Hot Tin Roof", scarJo.getActorArtWork().getOtherMedia()[0]);
    for (int i = 0; i < scarJoMovies.length; i++) {
      Assert.assertEquals(scarJoMovies[i], scarJo.getActorArtWork().getMovies()[i]);
    }
    for (int i = 0; i < scarJoSeries.length; i++) {
      Assert.assertEquals(scarJoSeries[i], scarJo.getActorArtWork().getSeries()[i]);
    }
    for (int i = 0; i < scarJoMedia.length; i++) {
      Assert.assertEquals(scarJoMedia[i], scarJo.getActorArtWork().getOtherMedia()[i]);
    }

  }
}