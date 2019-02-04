package problem1;

/**
 * represents an Photographer which is a subclass of AbstractArtist with all artist's parameters
 */
public class Photographer extends AbstractArtist {

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   * @throws IllegalArgumentException exception for if the age out of valid range
   */
  public Photographer(String name, Integer age, String active, String[] genre, String[] awards) {
    super(name, age, active, genre, awards);
  }
}
