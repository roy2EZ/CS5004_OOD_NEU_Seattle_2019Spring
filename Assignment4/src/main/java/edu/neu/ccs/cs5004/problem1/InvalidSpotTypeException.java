package edu.neu.ccs.cs5004.problem1;
/**
 * Represents the exception for disability type invalid parking
 *
 * @author Roy Chen
 * @version 1.0
 */
public class InvalidSpotTypeException extends Throwable {
  public InvalidSpotTypeException(String message) {
    super(message);
  }
}
