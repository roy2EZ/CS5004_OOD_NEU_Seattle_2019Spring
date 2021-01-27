package edu.neu.ccs.cs5004.assignment8.problem1;

/**
 * Exceptions when there is no such an alias in the library.
 */
public class NoSuchAliasException extends Exception {

  /**
   * Constructs a new exception with the specified detail message.
   *
   * @param message the detail message.
   */
  public NoSuchAliasException(String message) {
    super(message);
  }
}
