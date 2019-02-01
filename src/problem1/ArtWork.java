package problem1;

/**
 * represents a class with art works an artist performed
 * including movies, TV series and work on other multimedia
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public class ArtWork {
  private String[] movies;
  private String[] series;
  private String[] otherMedia;

  /**
   * @param movies the movies which the artist performed or participated
   * @param series the TV series which the artist performed or participated
   * @param otherMedia any other are work on multimedia such as YouTube, Netflix which the artist performed or participated
   */
  public ArtWork(String[] movies, String[] series, String[] otherMedia) {
    this.movies = movies;
    this.series = series;
    this.otherMedia = otherMedia;
  }

  /**
   * @return the movies which the artist performed or participated
   */
  public String[] getMovies() {
    return movies;
  }

  /**
   * @return the TV series which the artist performed or participated
   */
  public String[] getSeries() {
    return series;
  }

  /**
   * @return any other are work on multimedia which the artist performed or participated
   */
  public String[] getOtherMedia() {
    return otherMedia;
  }
}
