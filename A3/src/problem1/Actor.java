package problem1;

/**
 * represents an Actor which is a subclass of Artist
 * with all Artist's parameters and an ArtWork class with his art works
 */
public class Actor extends Artist {
  private ArtWork actorArtWork;

  /**
   * @param name the artist's name
   * @param age the artist's age between 0 and 128
   * @param active the artist's active period, for example "1982 - 1994"
   * @param genre the artist's genre, for example "Performing Art"
   * @param awards the awards which the artist achieved
   * @param artwork
   */
  public Actor(String name, Integer age, String active, String[] genre, String[] awards,
      ArtWork artwork) {
    super(name, age, active, genre, awards);
    this.actorArtWork = artwork;
  }

  /**
   * @return the art works of the actor
   */
  public ArtWork getActorArtWork() {
    return actorArtWork;
  }
}
