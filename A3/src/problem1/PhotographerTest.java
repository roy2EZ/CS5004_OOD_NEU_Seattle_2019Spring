package problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhotographerTest {
  private Photographer araki;
  private String[] arakiGenre;
  private String[] arakiAwards;
  @Before
  public void setUp() throws Exception {
    arakiGenre = new String[] {"Photographer", "Contemporary artist"};
    arakiAwards = new String[] {"Taiyo Prize", "Sun Prize", "Society of Photography Award",
        "Higashikawa Prize", "Japan Inter-Design Forum Grand Prix",
        "Austrian Decoration for Science and Art"};
    araki = new Photographer("Nobuyoshi Araki", 78, "1970 - present", arakiGenre,arakiAwards);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Nobuyoshi Araki", araki.getName());
  }

  @Test
  public void getAge() {

  }

  @Test
  public void getActive() {
  }

  @Test
  public void getGenre() {
  }

  @Test
  public void getAwards() {
  }
}