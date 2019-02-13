package edu.neu.ccs.cs5004.problem1;
/**
 * Represents the exception for size invalid parking
 *
 * @author Roy Chen
 * @version 1.0
 */
public class InvalidSpotSizeException extends Exception {
  public InvalidSpotSizeException(String message) {
    super(message);
  }
}
