package edu.neu.ccs.cs5004.problem2;


/**
 * Represents a List of Integers.
 * @author Rongyi Chen
 * @version 1.0
 */
public interface IBagOfWords {

  /**
   * Creates an empty BagOfWords.
   * @return an empty BagOfWords
   */
  BagOfWords emptyBagOfWords();

  /**
   * Calling isEmpty() on an empty BagOfWords returns true.
   * Calling isEmpty() on a non-empty BagOfWords tedBag returns false.
   * @return true if BagOfWords is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * return number of how many elements in the bag.
   * @return number of how many elements in the bag
   */
  int size();

  /**
   * Given a new string and add it to this bag of words.
   * @param string new string to add to the bag of words
   * @return updated BagOfWords with string prepended
   */
  BagOfWords add(String string);

  /**
   * consumes a String, and checks if the String is in the list or not.
   * @param element the string need to be check
   * @return true if string in the list and false otherwise
   */
  Boolean contains(String element);


}
