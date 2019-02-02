package problem1;

/**
 * represents an artist with name, age, active time,
 * genre and awards he or she achieved
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public class AbstractArtist implements IArtist {

  private String name;
  private Integer age;
  private String active;
  private String[] genre;
  private String[] awards;

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   * @throws IllegalArgumentException exception for if the age out of valid range
   */
  public AbstractArtist(String name, Integer age, String active, String[] genre, String[] awards) {
    this.name = name;
    if (age >= MIN_AGE && age <= MAX_AGE) {
      this.age = age;
    } else {
      throw new IllegalArgumentException(String.format("Age should be an integer between %d and %d", MIN_AGE, MAX_AGE));
    }
    this.active = active;
    this.genre = genre;
    this.awards = awards;
  }

  /**
   * @return full name of the artist
   */

  public String getName() {
    return name;
  }

  /**
   * @return age of the artist
   */

  public Integer getAge() {
    return age;
  }

  /**
   * @return active time period of artist
   */

  public String getActive() {
    return active;
  }

  /**
   * @return the enum Genre of the artist
   */

  public String[] getGenre() {
    return genre;
  }

  /**
   * @return awards the artist achieved
   */

  public String[] getAwards() {
    return awards;
  }
}
