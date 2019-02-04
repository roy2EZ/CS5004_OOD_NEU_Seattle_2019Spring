package problem1;

/**
 * represents an artist with name, age, active time,
 * genre and awards he or she achieved
 * and add ArtWork class as a reference
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public abstract class AbstractArtistWithWork extends AbstractArtist {

  protected ArtWork artWork;

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   * @param artWork the artist's art works
   * @throws IllegalArgumentException exception for if the age out of valid range
   */
  protected AbstractArtistWithWork(String name, Integer age, String active, String[] genre,
      String[] awards, ArtWork artWork) {
    super(name, age, active, genre, awards);
    this.artWork = artWork;
  }

  /**
   * @return the art work of artist
   */
  public ArtWork getArtWork() {
    return artWork;
  }
}
