package problem1;

/**
 * represents an Actor which is a subclass of Artist with all Artist's parameters
 */
public class Musician extends AbstractArtist {

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   */
  public Musician(String name, Integer age, String active, String[] genre, String[] awards) {
    super(name, age, active, genre, awards);
  }

}
