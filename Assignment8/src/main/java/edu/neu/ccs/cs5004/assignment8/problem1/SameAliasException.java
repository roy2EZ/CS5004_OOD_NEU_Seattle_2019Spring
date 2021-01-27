package edu.neu.ccs.cs5004.assignment8.problem1;


/**
 * Exception when there has the same alias in the library.
 */
public class SameAliasException extends Exception {

  /**
   * Constructs a new exception with the specified detail message.
   *
   * @param message the detail message.
   */
  public SameAliasException(String message) {
    super(message);
  }
}
