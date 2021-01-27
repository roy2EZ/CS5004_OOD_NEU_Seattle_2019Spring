package edu.neu.ccs.cs5004.assignment8.problem1;

import java.util.HashSet;
import java.util.Objects;


public class Media {

  private static final Integer INITIAL_REQUEST = 0;
  protected String alias;
  protected String title;
  protected Year releaseYear;
  protected HashSet<Name> directors;
  protected HashSet<Name> actors;
  protected Integer requestTime;

  /**
   * Creates a movie or TV series with given alias, title, release year, directors, actors.
   *
   * @param alias alias of the movie or TV series
   * @param title title of the movie or TV series
   * @param releaseYear release year of the movie or TV series
   * @param directors director(s) of the movie or TV series
   * @param actors actors of the movie or TV series
   */
  public Media(String alias, String title, Year releaseYear,
      HashSet<Name> directors, HashSet<Name> actors) {
    this.alias = alias;
    this.title = title;
    this.releaseYear = releaseYear;
    this.directors = directors;
    this.actors = actors;
    this.requestTime = INITIAL_REQUEST;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Media)) {
      return false;
    }
    Media media = (Media) obj;
    return Objects.equals(alias, media.alias)
        && Objects.equals(title, media.title)
        && Objects.equals(releaseYear, media.releaseYear)
        && Objects.equals(directors, media.directors)
        && Objects.equals(actors, media.actors)
        && Objects.equals(requestTime, media.requestTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, title, releaseYear, directors, actors, requestTime);
  }

  @Override
  public String toString() {
    return  title +" (or named \"" + alias + "\"," + releaseYear + "), "
        + directors.size() + " directors, "
        + actors.size() +" actors, "
        + "requestTime = " + requestTime;
  }
}
