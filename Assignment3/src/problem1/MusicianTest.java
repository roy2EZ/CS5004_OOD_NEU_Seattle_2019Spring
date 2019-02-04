package problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MusicianTest {
  private Musician davidTao;
  private String[] davidTaoGenre;
  private String[] getDavidTaoAwards;

  @Before
  public void setUp() throws Exception {

    davidTaoGenre = new String[]{"Singer", "Songwriter"};
    getDavidTaoAwards = new String[] {"Golden Melody Awards", "HITO Radio Music Awards"};
    davidTao = new Musician("David Tao", 49, "1997 - present", davidTaoGenre, getDavidTaoAwards);

}

  @Test
  public void getName() {
    Assert.assertEquals("David Tao", davidTao.getName());
  }

  @Test
  public void getAge() {
    Integer EXPECTED_AGE = 49;
    Assert.assertEquals(EXPECTED_AGE, davidTao.getAge());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAge() {
    Musician invalidAgeMusician = new Musician("test", 500, "test", davidTaoGenre,getDavidTaoAwards);
  }

  @Test
  public void getActive() {
    Assert.assertEquals("1997 - present", davidTao.getActive());
  }

  @Test
  public void getGenre() {
    Assert.assertArrayEquals(davidTaoGenre, davidTao.getGenre());
    Assert.assertEquals("Songwriter", davidTao.getGenre()[1]);
  }

  @Test
  public void getAwards() {
    Assert.assertArrayEquals(getDavidTaoAwards, davidTao.getAwards());
    Assert.assertEquals("Golden Melody Awards", davidTao.getAwards()[0]);
  }
}