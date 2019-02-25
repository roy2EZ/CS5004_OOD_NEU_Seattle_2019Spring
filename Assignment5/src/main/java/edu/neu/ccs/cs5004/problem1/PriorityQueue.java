package edu.neu.ccs.cs5004.problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a Heap-based priority queue
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public class PriorityQueue implements IPriorityQueue {

  private Element[] array; // binary tree base on heap
  private int index = 0; // elements restore in array[1] to array[]index, array[0] is not used
  private int maxN; // max number of how many elements in the queue

  public PriorityQueue(int maxN) {
    this.maxN = maxN;
    this.array = new Element[maxN + 1];
  }

  /**
   * creates an empty priority queue.
   * @param maxN max number of how many elements in the queue
   * @return a new empty PQ
   */
  public PriorityQueue createEmpty(int maxN) {
    PriorityQueue newEmpty = new PriorityQueue(maxN);
    return newEmpty;
  }


  /**
   * Check if queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    return index == 0;
  }

  /**
   * Returns how many elements in the queue.
   * @return size of the queue
   */
  public int size() {
    return index;
  }


  /**
   * Check if the queue is full.
   * @return true if the queue is full, false otherwise.
   */
  public boolean isFull() {
    return index == maxN;
  }


  /**
   * Insert the element into the queue.
   * @param element insert the element into the queue with correct priority
   */
  public void insert(Element element) {

    if (isFull()) {
      System.out.println("The Priority Queue is full.");
      return;
    }
    array[++index] = element;
    swim(index);
  }


  /**
   * adds the given value with its associated priority in PQ.
   * @param priority priority number of the element
   * @param value string as value in the element
   * @return the priority queue after element added
   */
  public PriorityQueue add(Integer priority, String value) {
    if (isFull()) {
      System.out.println("The Priority Queue is full.");
      return this;
    }
    Element element = new Element(priority, value);
    this.insert(element);
    return this;
  }

  /**
   * remove the highest priority element out of the queue and return it.
   * @return the highest priority element
   */
  public Element removeHighest() {
    if (isEmpty()) {
      System.out.println("The Priority Queue is empty.");
      return array[0];
    }
    Element max = array[1];//get highest priority element from root
    exchange(1, index--);// exchange it with the last element
    sink(1);// recover the queue to order
    return max;
  }

  /**
   * returns the PQ without the element with the highest priority.
   *
   * @return the PQ without the element with the highest priority.
   * @throws EmptyQueueException if PQ is empty
   */
  public PriorityQueue pop() throws EmptyQueueException {
    if (isEmpty()) {
      throw new EmptyQueueException("Not allowed to pop Empty PQ.");
    }
    this.removeHighest();
    return this;
  }

  /**
   * returns the value in PQ that has the highest priority.
   * @return the value in PQ that has the highest priority.
   * @throws EmptyQueueException if PQ is empty
   */
  public String peek() throws EmptyQueueException {
    if (isEmpty()) {
      throw new EmptyQueueException("Not allowed to peek Empty PQ.");
    }
    return this.getArray()[1].value;
  }



  // getters

  public int getMaxN() {
    return maxN;
  }

  public Element[] getArray() {
    return array.clone();
  }

  // helper methods

  // compare two index in the array
  private boolean less(int indexI, int indexJ) {
    if ((array[indexI].priority - array[indexJ].priority) < 0) {
      return true;
    } else {
      return false;
    }
  }

  // exchange elements at index i and j in array
  private void exchange(int indexI, int indexJ) {
    Element temp = array[indexI];
    array[indexI] = array[indexJ];
    array[indexJ] = temp;
  }


  /**
   * Bottom-up reheapify: If the heap order is violated because a node's key becomes
   * larger than that node's parents key, then we can make progress toward fixing
   * the violation by exchanging the node with its parent.
   */
  private void swim(int indexK) {
    while (indexK > 1 && less(indexK / 2, indexK)) {
      exchange(indexK / 2, indexK);
      indexK = indexK / 2;
    }
  }

  /**
   * Top-down heapify: If the heap order is violated because a node's key becomes smaller than one
   * or both of that node's children's keys, then we can make progress toward fixing the violation
   * by exchanging the node with the larger of its two children.
   */
  private void sink(int indexK) {
    while (2 * indexK <= index) {
      int indexJ = 2 * indexK;
      if (indexJ < index && less(indexJ, indexJ + 1)) {
        indexJ++;
      }
      if (!less(indexK, indexJ)) {
        break;
      }
      exchange(indexK, indexJ);
      indexK = indexJ;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PriorityQueue)) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) obj;
    return index == that.index
        && maxN == that.maxN
        && Arrays.equals(array, that.array);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(index, maxN);
    result = 31 * result + Arrays.hashCode(array);
    return result;
  }
}