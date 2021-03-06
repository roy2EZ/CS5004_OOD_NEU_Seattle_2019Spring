package edu.neu.ccs.cs5004.problem2;

import java.util.Objects;

/**
 * represents a bag of words ADT.
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public class BagOfWords extends AbstractBagOfWords {
  private Node head;
  private Node tail;

  /**
   * Constructs an empty bag.
   */
  public BagOfWords() {

  }

  /**
   * Constructs a bag with a string array that add each string elements in the array into the bag.
   */
  public BagOfWords(String[] strings) {
    super(strings);
  }

  // ---------- Homework required methods ----------

  /**
   * Creates an empty BagOfWords.
   *
   * @return an empty BagOfWords
   */
  @Override
  public BagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  /**
   * Calling isEmpty() on an empty BagOfWords returns true. Calling isEmpty() on a non-empty
   * BagOfWords tedBag returns false.
   *
   * @return true if BagOfWords is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * return number of how many elements in the bag.
   *
   * @return number of how many elements in the bag
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Given a new string and add it to this bag of words.
   *
   * @param string new string to add to the bag of words
   * @return updated BagOfWords with string prepended
   */
  @Override
  public BagOfWords add(String string) {
    this.addLast(string);
    return this;
  }

  /**
   * add the string element at the index location.
   * @param index the index where the element need to be added
   * @param string the string element which need to be added
   */
  public void add(int index,String string) {
    if (index == 0) {
      addFirst(string);
    } else if (index >= size) {
      addLast(string);
    } else {
      Node current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node temp = current.next;
      current.next = new Node(string);
      (current.next).next = temp;
      size++;
    }
  }

  /**
   * consumes a String, and checks if the String is in the list or not.
   * @param element the string need to be check
   * @return true if string in the list and false otherwise
   */
  @Override
  public Boolean contains(String element) {
    Node current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(element)) {
        return true;
      } else {
        current = current.next;
      }
    }
    return false;
  }


  /**
   * Override the toString() method, to output the BagOfWords.
   * @return a string with all elements in the bag
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BagOfWords" + '[');
    for (int i = 0; i < (this.size() - 1); i++) {
      stringBuilder.append(this.get(i) + ", ");
    }
    stringBuilder.append(this.getLast());
    stringBuilder.append(']');
    return stringBuilder.toString();
  }

  /**
   * override equals() method as homework requirements.
   * Remember that the order of elements in a BagOfWords does not matter.
   * @param obj another BagOfWords object
   * @return true if the two BagsOfWords have the same exact elements;
   *         exactly the same Strings and exactly the same number of times in the BagOfWords
   *         (if there are duplicates); false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof BagOfWords)) {
      return false;
    }
    BagOfWords that = (BagOfWords) obj;

    if (this.size() != that.size()) {
      return false;
    } else {
      BagOfWords thisRewrite = this.bagDuplicateRewrite();
      BagOfWords thatRewrite = that.bagDuplicateRewrite();
      if (thisRewrite.size() != thatRewrite.size()) {
        return false;
      } else {
        for (int i = 0; i < thisRewrite.size(); i++) {
          if (!thatRewrite.contains(thisRewrite.get(i))) {
            return false;
          }
        }
        return true;
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, tail);
  }

  // other helper functions I designed here or implement from AbstractBagOfWords.
  /**
   * get the string at index position.
   * @param index the position in the bag
   * @return the string element at that index
   */
  public String get(int index) {
    if (index < 0 || index >= size) {
      return null;
    } else if (index == 0) {
      return head.element;
    } else if (index == size - 1) {
      return tail.element;
    } else {
      Node current = this.head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node temp = current.next;
      return temp.element;
    }
  }

  /**
   * remove string at index position.
   * @param index the position which string need to be removed
   * @return the removed string
   */
  public String remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    } else if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    } else {
      Node previous;
      previous = this.head;
      for (int i = 1;i < index;i++) {
        previous = previous.next;
      }
      Node current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /**
   * get first string.
   * @return the first string
   */
  public String getFirst() {
    if (size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  /**
   * get last string.
   * @return the last string
   */
  public String getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  /**
   * add string element at first index (index 0).
   * @param string the string need to be added
   */
  public void addFirst(String string) {
    Node newNode = new Node(string);
    newNode.next = head;
    head = newNode;
    size++;
    if (tail == null) {
      tail = head;
    }
  }

  /**
   * add string element at last index.
   * @param string the string need to be added
   */
  public void addLast(String string) {
    Node newNode = new Node(string);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
  }

  /**
   * remove first string.
   * @return the removed string
   */
  public String removeFirst() {
    if (size == 0) {
      return null;
    } else if (size == 1) {
      Node temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    } else {
      Node temp = head;
      head = head.next;
      size--;
      return temp.element;
    }
  }

  /**
   * remove the last string.
   * @return the removed string
   */
  public String removeLast() {
    if (size == 0) {
      return null;
    } else if (size == 1) {
      Node temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    } else {
      Node current = head;
      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }
      tail = current;
      Node temp = tail;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  // Below is all the methods about duplicates operation,
  // to make sure the BagOfWords can be with duplicated elements,
  // and prepare for overriding the equal() method.

  /**
   * check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element and false otherwise.
   */
  public Boolean hasDuplicates() {

    BagOfWords tempList = this.bagClone();
    Node temp = tempList.head;
    for (int i = 0; i < this.size(); i++) {
      tempList.removeFirst();
      if (tempList.contains(temp.element)) {
        return true;
      } else {
        temp = temp.next;
      }
    }
    return false;
  }

  /**
   * get the number of how many times the string str duplicates in the Bag.
   * @param str the string which need to check
   * @return the number of how many times the string str duplicates in the Bag
   */
  public int numOfDuplicated(String str) {
    if (!this.contains(str)) {
      return 0;
    } else {
      Integer numOfDuplicated = 0;
      for (int i = 0; i < this.size(); i++) {
        if (this.get(i).equals(str)) {
          numOfDuplicated += 1;
        }
      }
      return numOfDuplicated;
    }
  }

  /**
   * clone the bag.
   * @return a copy of the bag
   */
  public BagOfWords bagClone() {
    // copy the origin bag
    BagOfWords copyBag = new BagOfWords();
    Node curr = this.head;
    for (int i = 0; i < this.size(); i++) {
      copyBag.add(curr.element);
      curr = curr.next;
    }
    return copyBag;
  }

  /**
   * remove the duplicated elements in the bag to return a bag without duplicated elements.
   * @return a bag without duplicated elements, and has all original bag's elements
   */
  public BagOfWords removeDuplicates() {
    // copy the origin bag
    BagOfWords copyBag = this.bagClone();
    BagOfWords resultBag = new BagOfWords();
    while (!copyBag.isEmpty()) {
      if (copyBag.numOfDuplicated(copyBag.getFirst()) > 1) {
        copyBag.removeFirst();
      } else {
        resultBag.add(copyBag.removeFirst());
      }
    }
    return resultBag;
  }

  /**
   * return the index where the string appears in the bag first time from front to end.
   * @param str the string which need to check
   * @return the string's index
   */
  public int firstIndexOf(String str) {
    if (this.size() == 0) {
      return -1;
    } else {
      Node current = head;
      for (int i = 0; i < size; i++) {
        if (current.element.equals(str)) {
          return i;
        } else {
          current = current.next;
        }
      }
    }
    return -1;
  }

  /**
   * To rewrite the Bag with duplicated words into a new bag of words with no duplicated way.
   * For example, [I,love,you,and,you,love,me] will be rewrite as [I,2love,2you,and,me],
   * in this way the new Set will have unique elements for later compare.
   * @return the new BagOfWords with new way to show the old BagOfWords without duplicates.
   */
  public BagOfWords bagDuplicateRewrite() {
    if (!this.hasDuplicates()) {
      return this;
    } else {
      // create a new bag with unique elements in old bag
      BagOfWords uniqueBag = this.removeDuplicates();
      // also create an empty to store rewrite results
      BagOfWords rewriteBag = new BagOfWords();
      for (int i = 0; i < uniqueBag.size(); i++) {
        Integer num = this.numOfDuplicated(uniqueBag.get(i));
        rewriteBag.add(num.toString() + uniqueBag.get(i));
      }
      return rewriteBag;
    }
  }

}
