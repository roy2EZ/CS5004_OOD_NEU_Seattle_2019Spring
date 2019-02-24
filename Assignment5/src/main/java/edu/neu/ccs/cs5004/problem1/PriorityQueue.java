package edu.neu.ccs.cs5004.problem1;

public class PriorityQueue {

  private Element[] array; // the array to store the elements
  private int N = 0; // elements restore in array[1] to array[]N, array[0] is not used
  private int maxN; //

  public PriorityQueue(int maxN) {
    this.maxN = maxN;
    this.array = new Element[maxN + 1];
  }

  public Element[] getArray() {
    return array;
  }
  
  /**
   * Check if queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * Returns how many elements in the queue.
   * @return
   */
  public int size() {
    return N;
  }


  /**
   * Check if the queue is full.
   * @return true if the queue is full, false otherwise.
   */
  public boolean isFull() {
    return N == maxN;
  }


  /**
   * Insert the element into the queue.
   * @param element insert the element into the queue with correct priority
   */
  public void insert(Element element) {

    if(isFull()) {
      System.out.println("The Priority Queue is full.");
      return;
    }
    array[++N] = element;
    swim(N);
  }


  /**
   * adds the given value with its associated priority in PQ.
   * @param priority priority number of the element
   * @param value string as value in the element
   * @return the priority queue after element added
   */
  public PriorityQueue add(Integer priority, String value) {
    if(isFull()) {
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
  public Element removeHighest(){
    if(isEmpty()) {
      System.out.println("The Priority Queue is empty.");
      return array[0];
    }
    Element max = array[1];//get highest priority element from root
    exchange(1,N--);// exchange it with the last element
    sink(1);// recover the queue to order
    return max;
  }

  /**
   * returns the PQ without the element with the highest priority.
   *
   * @return the PQ without the element with the highest priority.
   * @throws EmptyPQException
   */
  public PriorityQueue pop() throws EmptyPQException {
    if(isEmpty()) {
      throw new EmptyPQException("Not allowed to pop Empty PQ.");
    }
    this.removeHighest();
    return this;
  }

  /**
   * returns the value in PQ that has the highest priority.
   * @return the value in PQ that has the highest priority.
   * @throws EmptyPQException
   */
  public String peek() throws EmptyPQException {
    if(isEmpty()) {
      throw new EmptyPQException("Not allowed to peek Empty PQ.");
    }
    return this.getArray()[1].value;
  }

  // helper methods

  private boolean less(int i, int j) {
    if((array[i].priority -array[j].priority) < 0)
      return true;
    else
      return false;
  }

  private void exchange(int i, int j) {
    Element temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exchange(k/2, k);
      k = k/2;
    }
  }

  private void sink(int k) {
    while (2*k <= N) {
      int j = 2*k;
      if(j < N && less(j, j+1))
        j++;
      if(!less(k, j))
        break;
      exchange(k, j);
      k = j;
    }
  }


}