package edu.neu.ccs.cs5004.problem2;

/**
 * Represents abstract BagOfWords ADT
 * with some helper methods and two constructors
 *
 * @author Rongyi Chen
 * @version 1.0
 */
public abstract class AbstractBagOfWords implements IBagOfWords {
  protected int size = 0;

  /**
   * Constructs an empty bag.
   */
  public AbstractBagOfWords() {

  }

  /**
   * Constructs a bag with a string array.
   * that add each string elements in the array into the bag.
   * @param strings the string array with the strings which need to be added into the bag.
   */
  protected AbstractBagOfWords(String[] strings) {
    for (int i = 0 ; i < strings.length; i++) {
      add(strings[i]);
    }
  }


  // other helper functions which need implement in BagOfWords class

  /**
   * get the string at index position.
   * @param index the position in the bag
   * @return the string element at that index
   */
  public String get(int index) {
    return null;
  }

  /**
   * add the string element at the index location.
   * @param index the index where the element need to be added
   * @param string the string element which need to be added
   */
  public void add(int index, String string) {}

  /**
   * remove string at index position.
   * @param index the position which string need to be removed
   * @return the removed string
   */
  public String remove(int index) {
    return null;
  }

}
