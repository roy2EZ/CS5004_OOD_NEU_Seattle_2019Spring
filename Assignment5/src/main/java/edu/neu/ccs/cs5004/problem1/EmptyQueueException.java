package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the exception when pop() or peek() an empty PQ.
 */
public class EmptyQueueException extends Exception {
  public EmptyQueueException(String msg) {
    super(msg);
  }
}
