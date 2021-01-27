package edu.neu.ccs.cs5004.assignment8.problem1;

/**
 * Represents the exception when the year of publication is illegal.
 */
public class IllegalYearException extends Exception {
  /**
   * Create an illegal year exception.
   *
   * @param message warning message of illegal year
   */
  public IllegalYearException(String message) {
    super(message);
  }
}
