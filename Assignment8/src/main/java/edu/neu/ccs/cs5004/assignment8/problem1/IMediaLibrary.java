package edu.neu.ccs.cs5004.assignment8.problem1;

import java.util.List;

/**
 * Represents the actions of a Media Library.
 */
public interface IMediaLibrary {
  String NO_SUCH_ALIAS_MESSAGE = "There is no such alias in the library.";
  String SAME_ALIAS_MESSAGE = "The alias has already been in the library.";

  /**
   * Gets all the movies and TV series' that that director directed.
   * @param name director's name
   * @return list of media
   */
  List<Media> directorMedia(Name name);

  /**
   * Adds a new movie or TV series to the media library.
   * @param media a new media
   * @throws SameAliasException if library has same alias of the media
   */
  void addMedia(Media media) throws SameAliasException;

  /**
   * Increase times that the movie/TV series was streamed.
   * @param alias movie/TV's alias
   * @throws NoSuchAliasException if the alias does not exist
   */
  void addStreamedTimes(String alias) throws NoSuchAliasException;

  /**
   * Returns the times that the media was streamed.
   * @param alias movie/TV's alias
   * @return times that the media was streamed
   * @throws NoSuchAliasException if the alias does not exist
   */
  Integer getStreamedTimes(String alias) throws NoSuchAliasException;

  /**
   * Returns the most streamed movie or TV series.
   * @return the most streamed movie or TV series
   */
  Media getMostStreamedMedia();
}
