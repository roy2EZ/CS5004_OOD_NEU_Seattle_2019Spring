package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the interface of priority queue (PQ).
 */
public interface IPriorityQueue {

  /**
   * creates an empty priority queue.
   * @param maxN max size of PQ
   * @return PQ
   */
  PriorityQueue createEmpty(int maxN);

  /**
   * adds the given value with its associated priority in PQ.
   * @param priority priority
   * @param value the string
   * @return PQ
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * returns the value in PQ that has the highest priority.
   * @return the value in PQ that has the highest priority.
   * @throws EmptyQueueException Calling peek() on an empty PQ
   */
  String peek() throws EmptyQueueException;

  /**
   * returns the PQ without the element with the highest priority.
   * @return the PQ without the element with the highest priority.
   * @throws EmptyQueueException Calling pop() on an empty PQ
   */
  PriorityQueue pop() throws EmptyQueueException;

  /**
   * returns true if the PQ is empty, returns false otherwise.
   * @return true if the PQ is empty, returns false otherwise.
   */
  boolean isEmpty();
}
