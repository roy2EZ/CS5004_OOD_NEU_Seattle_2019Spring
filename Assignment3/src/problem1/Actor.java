package problem1;

/**
 * represents an Actor which is a subclass of AbstractArtistWithWork
 * with all artist's parameters and an ArtWork class with his art works
 */
public class Actor extends AbstractArtistWithWork {

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   * @param artWork the artist's art works
   * @throws IllegalArgumentException exception for if the age out of valid range
   */
  public Actor(String name, Integer age, String active, String[] genre, String[] awards,
      ArtWork artWork) {
    super(name, age, active, genre, awards, artWork);
  }

}
