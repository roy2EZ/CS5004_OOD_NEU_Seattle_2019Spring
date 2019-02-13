package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the exception when vehicle disability type not valid for spot
 * @author Roy Chen
 * @version 1.0
 */
public class InvalidSpotTypeException extends Throwable {
  public InvalidSpotTypeException(String message) {
    super(message);
  }
}
