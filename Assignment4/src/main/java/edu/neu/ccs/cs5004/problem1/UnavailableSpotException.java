package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the exception spot is taken
 * @author Roy Chen
 * @version 1.0
 */
public class UnavailableSpotException extends Throwable {
  public UnavailableSpotException(String message) {
    super(message);
  }
}
