package problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PainterTest {
  private Painter picasso;
  private String[] picassoGenre;
  private String[] picassoAwards;

  @Before
  public void setUp() throws Exception {
    picassoGenre = new String[] {"Painting", "Drawing", "Sculpture", "Printmaking", "Ceramics", "Stage design", "Writing"};
    picassoAwards = new String[] {"Lenin Peace Prize"};
    picasso = new Painter("Pablo Picasso", 91, "before 1900 - 1973", picassoGenre, picassoAwards);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Pablo Picasso", picasso.getName());
  }

  @Test
  public void getAge() {
    final Integer EXPECTED_AGE = 91;
    Assert.assertEquals(EXPECTED_AGE, picasso.getAge());
  }

  @Test
  public void getActive() {
    Assert.assertEquals("before 1900 - 1973", picasso.getActive());
  }

  @Test
  public void getGenre() {
    Assert.assertArrayEquals(picassoGenre,picasso.getGenre());
    Assert.assertEquals("Sculpture", picasso.getGenre()[2]);
    for (int i = 0; i < picassoGenre.length; i++) {
      Assert.assertEquals(picassoGenre[i], picasso.getGenre()[i]);
    }
  }

  @Test
  public void getAwards() {
    Assert.assertArrayEquals(picassoAwards, picasso.getAwards());
    Assert.assertEquals("Lenin Peace Prize", picasso.getAwards()[0]);
  }
}