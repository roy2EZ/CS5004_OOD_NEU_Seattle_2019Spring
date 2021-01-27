package edu.neu.ccs.cs5004.assignment8.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MediaLibrary implements IMediaLibrary{
  public HashMap<String, Media> library;

  /**
   * Creates a media library.
   */
  public MediaLibrary(HashMap<String, Media> library) {
    this.library = library;
  }

  /**
   * Get all the movies and TV series that the director directed.
   *
   * @param name director's name
   * @return list of media
   */
  @Override
  public List<Media> directorMedia(Name name) {
    List<Media> output = new ArrayList<>();
    for (Media media : this.library.values()){
      if (media.directors.contains(name)){
        output.add(media);
      }
    }
    output.sort(Comparator.comparingInt((media)->media.releaseYear.getYear()));
    Collections.reverse(output);
    return output;
  }


  /**
   * Add a new movie or TV series to the media library.
   *
   * @param media a new media
   * @throws SameAliasException if library has same alias of the media
   */
  @Override
  public void addMedia(Media media) throws SameAliasException {
    //If the specified key is not already associated with a value associate it and returns null
    if (this.library.putIfAbsent(media.alias, media) != null) {
      throw new SameAliasException(SAME_ALIAS_MESSAGE);
    }
  }

  /**
   * Increase the times that the movie/TV series was streamed.
   *
   * @param alias media's alias
   * @throws NoSuchAliasException if the alias does not exist
   */
  @Override
  public void addStreamedTimes(String alias) throws NoSuchAliasException {
    Media media = this.library.get(alias);
    if (media == null) {
      throw new NoSuchAliasException(NO_SUCH_ALIAS_MESSAGE);
    }
    media.requestTime++;
  }

  /**
   * Returns the times that the media was streamed.
   *
   * @param alias movie/TV's alias
   * @return times that the media was streamed
   * @throws NoSuchAliasException if the alias does not exist
   */
  @Override
  public Integer getStreamedTimes(String alias) throws NoSuchAliasException {
    Media media = this.library.get(alias);
    if (media == null) {
      throw new NoSuchAliasException(NO_SUCH_ALIAS_MESSAGE);
    }
    return media.requestTime;
  }

  /**
   * Returns the most streamed movie or TV series.
   *
   * @return the most streamed movie or TV series
   */
  @Override
  public Media getMostStreamedMedia() {
    Media output = null;
    for (Media media : this.library.values()) {
      if (output == null || output.requestTime < media.requestTime) {
        output = media;
      }
    }
    return output;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof MediaLibrary)) {
      return false;
    }
    MediaLibrary that = (MediaLibrary) obj;
    return Objects.equals(library, that.library);
  }

  @Override
  public int hashCode() {
    return Objects.hash(library);
  }

  @Override
  public String toString() {
    return "MediaLibrary{" + library + '}';
  }
}