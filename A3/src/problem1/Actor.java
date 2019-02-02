package problem1;

/**
 * represents an Actor which is a subclass of AbstractArtistWithWork
 * with all artist's parameters and an ArtWork class with his art works
 */
public class Actor extends AbstractArtistWithWork {

  /**
   * @param name
   * @param age
   * @param active
   * @param genre
   * @param awards
   * @param artWork
   */
  public Actor(String name, Integer age, String active, String[] genre, String[] awards,
      ArtWork artWork) {
    super(name, age, active, genre, awards, artWork);
  }

}
