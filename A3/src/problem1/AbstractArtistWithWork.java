package problem1;

public class AbstractArtistWithWork extends AbstractArtist {
  private ArtWork artWork;

  public AbstractArtistWithWork(String name, Integer age, String active, String[] genre,
      String[] awards, ArtWork artWork) {
    super(name, age, active, genre, awards);
    this.artWork = artWork;
  }

  public ArtWork getArtWork() {
    return artWork;
  }
}
